/* 
 *	Created by Rhys Anton Gabion April 13, 2015
 *	Copyright (c) Unilab. All rights reserved.
 */
package com.unilab.workplace.database.external;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelperExternal extends SQLiteOpenHelper {

	private static final String TAG = DatabaseHelperExternal.class
			.getSimpleName();
	private EngineDatabaseExternal mDatabase;
	public static DatabaseHelperExternal dbManager;
	public static SQLiteDatabase sqlDb;
	public Context context;

	public static String l_externalPath;
	public static boolean l_isOverwrite;

	/**
	 * @param context
	 *            - application context
	 * @param database
	 *            - database
	 */
	public DatabaseHelperExternal(Context context, String externalPath,
			EngineDatabaseExternal database) {

		super(context, database.getName(), null, database.getVersion());
		this.context = context;
		this.l_externalPath = externalPath;
		mDatabase = database;
		if (mDatabase.isCopyFromAsset()) {
			copyFromAssets();
		}
	}

	/**
	 * Get Database Path
	 */

	public static String databasePath(Context context, String databaseName) {
		String databasePath;
		if (android.os.Build.VERSION.SDK_INT >= 17) {
			databasePath = context.getApplicationInfo().dataDir + "/databases/"
					+ databaseName;
		} else {
			databasePath = "/data/data/" + context.getPackageName()
					+ "/databases/" + databaseName;
		}
		return databasePath;
	}

	/**
	 * Get Database Path External
	 */

	public static String databasePathExternal(Context context,
			String databaseName) {
		String databasePath;

		databasePath = Environment.getExternalStorageDirectory() + "/"
				+ l_externalPath + "/" + databaseName;

		return databasePath;
	}

	/**
	 * creates the database tip: call this app in the activity that is launch
	 * initially
	 * 
	 * @param context
	 *            - the application's context
	 * @param database
	 *            - the database information of the app
	 */
	public static void createDatabase(Context context, String externalPath,
			EngineDatabaseExternal database, boolean isOverwrite) {
		l_externalPath = externalPath;
		l_isOverwrite = isOverwrite;
		if (dbManager == null) {
			dbManager = new DatabaseHelperExternal(context, l_externalPath,
					database);
		}
	}

	/**
	 * @return the instance of the helper class - returns null when the database
	 *         is not yet created
	 */
	public static DatabaseHelperExternal getInstance() {
		return dbManager;
	}

	/**
	 * @return the instance of the database information set when creating the
	 *         database - returns null when the database is not yet created
	 */
	public EngineDatabaseExternal getDatabaseInfo() {
		return mDatabase;
	}

	public void close() {
		dbManager = null;
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(TAG, "database create");
		sqlDb = db;
		if (!mDatabase.isCopyFromAsset()) {
			for (TableExternal table : mDatabase.getTables()) {
				Log.i(TAG, "adding database : " + table.getName());
				db.execSQL(table.getTableStructure());
			}
		}

	}

	/**
	 * @param db
	 * 
	 */
	private void copyFromAssets() {
		Log.i(TAG, "copy from assets");
		try {

			if (!doesDatabaseExist(context, mDatabase.getName())
					|| l_isOverwrite == true) {
				SQLiteDatabase db = this.getReadableDatabase();

				File sourceDBFile = new File(databasePathExternal(context,
						mDatabase.getName()));

				if (sourceDBFile.exists()) {
					FileInputStream sourceDBStream = new FileInputStream(
							sourceDBFile);

					copyDatabase(sourceDBStream,
							databasePath(context, mDatabase.getName()));
					for (TableExternal table : mDatabase.getTables()) {
						Log.i(TAG, "adding database : " + table.getName());

						if (table.getTableStructure() != null) {
							if (!table.getTableStructure().equals("")) {
								db.execSQL(table.getTableStructure());
							}
						}

					}
				} else {
					Toast.makeText(context, "External database not exist!",
							Toast.LENGTH_SHORT).show();
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		for (TableExternal table : mDatabase.getTables()) {
			db.execSQL("DROP TABLE IF EXISTS " + table.getName());
		}

		onCreate(db);

	}

	/**
	 * 
	 * @param sourceDB
	 *            - InputStream object of the database to be copied
	 * @param outputPath
	 *            - path to the database of the app
	 * 
	 */
	public boolean copyDatabase(InputStream sourceDB, String outputPath) {

		try {
			Log.i(TAG, "copy database : " + outputPath);
			InputStream myInput = sourceDB;
			String outFileName = outputPath;
			OutputStream myOutput = new FileOutputStream(outFileName);

			// transfer bytes from the inputfile to the outputfile
			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer)) > 0) {
				myOutput.write(buffer, 0, length);
			}

			// Close the streams
			myOutput.flush();
			myOutput.close();
			myInput.close();

			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	@SuppressLint("NewApi")
	public void exportDB(String dbPath, String dir) {

		File sdFile = new File(dir);
		if (!sdFile.exists())
			sdFile.mkdirs();

		FileChannel source = null;
		FileChannel destination = null;
		String backupDBPath = getDatabaseName();
		File currentDB = new File(dbPath); // just added backupDBPath for test
											// // default is dbPath only
		File backupDB = new File(dir, backupDBPath);

		try {
			source = new FileInputStream(currentDB).getChannel(); // default is
																	// currentDB
			destination = new FileOutputStream(backupDB).getChannel(); // default
																		// is
																		// backupDB
			destination.transferFrom(source, 0, source.size());
			source.close();
			destination.close();
			System.out.println("DB Exported");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressLint("NewApi")
	public static void exportDB(String dbPath, String dir, String dataseName) {

		File sdFile = new File(dir);
		if (!sdFile.exists())
			sdFile.mkdirs();

		FileChannel source = null;
		FileChannel destination = null;
		File currentDB = new File(dbPath); // just added backupDBPath for test
											// // default is dbPath only
		File backupDB = new File(dir, dataseName);

		try {
			source = new FileInputStream(currentDB).getChannel(); // default is
																	// currentDB
			destination = new FileOutputStream(backupDB).getChannel(); // default
																		// is
																		// backupDB
			destination.transferFrom(source, 0, source.size());
			source.close();
			destination.close();
			System.out.println("DB Exported: " + backupDB.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean doesDatabaseExist(Context context, String dbName) {
		File dbFile = context.getDatabasePath(dbName);
		return dbFile.exists();
	}

}
