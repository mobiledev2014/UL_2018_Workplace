package com.unilab.workplace.database.table;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.unilab.workplace.database.Table;
import com.unilab.workplace.database.model.MainCatModel;

import java.util.ArrayList;

/**
 * Created by c_alraygon on 11/7/2016.
 */
public class MainCatTable extends Table {

    Context context;
    public final static String TABLE_NAME = "main_cat_tbl";
    //DATABASE COLUMNS
    public final static String ID = "id";
    public final static String DESCRIPTION = "description";
    public final static String SELECTOR_IMG = "selector_img";

    public final static String TABLE_STRUCTURE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " TEXT" + DESCRIPTION
            + " TEXT " + SELECTOR_IMG + " TEXT " +");";

    public MainCatTable(Context context){
        this.context = context;
    }
    @Override
    public String getTableStructure() {
        return TABLE_STRUCTURE;
    }

    @Override
    public String getName() {
        return TABLE_NAME;
    }

    public int getCount() {
        return rawQuery("SELECT * FROM " + TABLE_NAME,null).getCount();
    }

    public ArrayList<MainCatModel> getAllMainCategory(){
        ArrayList<MainCatModel> mainCatModelList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDB();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        MainCatModel obj = new MainCatModel();
                        //column
                        obj.setId(cursor.getString(cursor.getColumnIndex(ID)));
                        obj.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION)));
                        obj.setSelector_img(cursor.getString(cursor.getColumnIndex(SELECTOR_IMG)));
                        mainCatModelList.add(obj);
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { db.close(); } catch (Exception ignore) {}
        }
        Log.d("MainCatTable", "getAllMainCategory: "+mainCatModelList.toString());
        return mainCatModelList;
    }
}
