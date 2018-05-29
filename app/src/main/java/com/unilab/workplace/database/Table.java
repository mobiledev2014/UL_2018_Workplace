/* 
 *	Created by Rhys Anton Gabion April 13, 2015
 *	Copyright (c) Unilab. All rights reserved.
 */
package com.unilab.workplace.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public abstract class Table {

	private SQLiteDatabase db;

	/**
	 * Write your table structure here
	 * 
	 * @return table structure. If you imported your database in assets or in
	 *         SD, return a "null" value;
	 */
	public abstract String getTableStructure();

	/**
	 * Get table name
	 * 
	 * @return table name
	 */
	public abstract String getName();

	public long insert(ContentValues values) {

		db = getWritableDB();

		if (db != null)
			return db.insertOrThrow(getName(), null, values);
		return -1;

	}

	public long insertOrUpdate(ContentValues values, String filter) {

		db = getWritableDB();

		int rowsAffected = db.update(getName(), values, filter, null);

		if (rowsAffected == 0)
			return db.insertOrThrow(getName(), null, values);

		return rowsAffected;
	}

	public int updateAll(ContentValues values) throws SQLiteException,
			SQLException {

		db = getWritableDB();

		if (db != null)
			return db.update(getName(), values, null, null);
		return -1;
	}

	public int update(ContentValues values, String filter)
			throws SQLiteException, SQLException {

		db = getWritableDB();

		if (db != null)
			return db.update(getName(), values, filter, null);
		return -1;
	}

	public int update(ContentValues values, String whereClause,
			String[] filterValues) throws SQLiteException, SQLException {

		db = getWritableDB();

		if (db != null)
			return db.update(getName(), values, whereClause, filterValues);
		return -1;
	}

	public int delete() throws SQLiteException, SQLException {

		db = getWritableDB();

		if (db != null)
			return db.delete(getName(), null, null);
		return -1;
	}

	public int delete(String whereClause, String[] filterValues)
			throws SQLiteException, SQLException {

		db = getWritableDB();

		if (db != null)
			return db.delete(getName(), whereClause, filterValues);
		return -1;
	}

	public Cursor select() throws SQLiteException, SQLException {

		db = getReadableDB();

		if (db != null)
			return db.rawQuery("SELECT * FROM " + getName(), null);
		return null;
	}

	// public Cursor select(String filter,String[] filterValues) throws
	// SQLiteException , SQLException {
	// db = DatabaseHelper.getInstance().getReadableDatabase();
	// if(db != null) return db.rawQuery( "SELECT * FROM " + getName() +
	// " where " + filter, filterValues );
	// return null;
	// }

	public Cursor rawQuery(String query, String[] filterValues)
			throws SQLiteException, SQLException {

		db = getReadableDB();

		if (db != null)
			return db.rawQuery(query, filterValues);
		return null;
	}

	// convert from bitmap to byte array
	public static byte[] getBytes(Bitmap bitmap) {
		if (bitmap == null)
			return null;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
		return stream.toByteArray();
	}

	// convert from byte array to bitmap
	public static Bitmap getImage(byte[] image) {
		if (image == null)
			return null;
		return BitmapFactory.decodeByteArray(image, 0, image.length);
	}

	// - JAY METHODS - START

	public Cursor select(String filter, String[] filterValues)
			throws SQLiteException, SQLException {

		db = getReadableDB();

		if (db != null)
			return db.query(getName(), null, filter, filterValues, null, null,
					null);
		return null;
	}

	public SQLiteDatabase getWritableDB() {
		SQLiteDatabase db;

		db = DatabaseHelper.getInstance().getWritableDatabase();

		return db;
	}

	public SQLiteDatabase getReadableDB() {
		SQLiteDatabase db;

		db = DatabaseHelper.getInstance().getReadableDatabase();

		return db;
	}

	// - JAY METHODS- END

	// Jin De
	public void JinUpdate(String sql) {
		SQLiteDatabase db = DatabaseHelper.getInstance().getReadableDatabase();
		db.execSQL(sql);
	}
	// Jin De
	public void updateTable(String sql) throws SQLiteException, SQLException {
		db = DatabaseHelper.getInstance().getReadableDatabase();
		db.execSQL(sql);
	}

}
