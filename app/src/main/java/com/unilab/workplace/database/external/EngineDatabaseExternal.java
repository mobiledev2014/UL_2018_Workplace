/* 
 *	Created by Rhys Anton Gabion April 13, 2015
 *	Copyright (c) Unilab. All rights reserved.
 */
package com.unilab.workplace.database.external;

import java.util.ArrayList;

public class EngineDatabaseExternal {

	private String DBName;
	private int DBVersion;
	private boolean isCopyFromAsset;
	private ArrayList<TableExternal> tables = new ArrayList<TableExternal>();
	/**
	 * 
	 * @param dbname - database name
	 * @param dbversion - database version
	 * 
	 */
	public EngineDatabaseExternal(String dbname , int dbversion) {
		DBName = dbname;
		DBVersion = dbversion;
	}
	
	/**
	 * 
	 * @param dbname - database name
	 * @param dbversion - database version
	 * 
	 */
	public EngineDatabaseExternal(String dbname , int dbversion, boolean isCopyFromAsset) {
		DBName = dbname;
		DBVersion = dbversion;
		this.isCopyFromAsset = isCopyFromAsset;
	}
	
	/**
	 * 
	 * @return database name
	 */
	public String getName() {
		return DBName;
	}
	
	/**
	 * 
	 * @return database version
	 */
	public int getVersion() {
		return DBVersion;
	}
	
	/**
	 * 
	 * @return an arraylist of tables to be created
	 */
	public ArrayList<TableExternal> getTables() {
		return tables;
	}
	
	/**
	 * 
	 * @param table - table to be added to the list
	 * @return instance of the EngineDatabase Class
	 */
	public EngineDatabaseExternal addTable(TableExternal table) {
		tables.add(table);
		return this;
	}

	public boolean isCopyFromAsset() {
		return isCopyFromAsset;
	}

}
