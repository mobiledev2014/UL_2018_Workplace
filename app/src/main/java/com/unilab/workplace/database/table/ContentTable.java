package com.unilab.workplace.database.table;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.unilab.workplace.database.Table;
import com.unilab.workplace.database.model.SearchModel;

import java.util.ArrayList;

/**
 * Created by c_alraygon on 11/4/2016.
 */

public class ContentTable extends Table {

    Context context;
    public final static String TABLE_NAME = "content_tbl";
    //DATABASE COLUMNS
    public final static String ID = "id";
    public final static String TITLE = "title";
    public final static String TITLE_SEC_ID = "title_sec_id";
    public final static String TITLE_DESC = "title_desc";
    public final static String CONTENT_IMG_ID = "content_img_id";
    public final static String SUB_CAT_ID = "sub_cat_id";
    public final static String DESCRIPTION = "description";
//    public final static String EMP_READTERMS = "emp_readterms";
//    public final static String EMP_MODIFIED = "emp_modified";


    public final static String TABLE_STRUCTURE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " TEXT" + TITLE
            + " TEXT " + TITLE_SEC_ID + " TEXT" + TITLE_DESC + "TEXT" +
            CONTENT_IMG_ID + " TEXT" + SUB_CAT_ID + " TEXT" +
            DESCRIPTION + " TEXT" +");";

    public final static String TAG = "ContentTable";


    public ContentTable(Context context){
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

    public ArrayList<SearchModel> doSearch(String query) {

        ArrayList<SearchModel> searchModelArrayList = new ArrayList<>();
        //String selectQuery2 = "SELECT c.id,c.description,c.sub_cat_id FROM content_tbl as c INNER JOIN sub_cat_tbl as s ON c.sub_cat_id = s.id WHERE (s.description || ' ' || c.description) LIKE '%" + query + "%' ORDER BY c.id DESC";
        String selectQuery3 = "SELECT c.id,c.description,c.sub_cat_id,c.title_desc FROM content_tbl as c WHERE c.description LIKE '%"+query+"%' ORDER BY c.id ASC";
        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDB();
        try {

            Cursor cursor = db.rawQuery(selectQuery3, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SearchModel searchModel = new SearchModel();
                        //column
                        searchModel.setId(cursor.getString(cursor.getColumnIndex(ID)));
                        searchModel.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION)));
                        searchModel.setCat_id(cursor.getString(cursor.getColumnIndex(SUB_CAT_ID)));
                        searchModel.setTitle_desc(cursor.getString(cursor.getColumnIndex(TITLE_DESC)));
                        searchModelArrayList.add(searchModel);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();
                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {
            }
        }
        Log.e(TAG,"test:"+searchModelArrayList.size());
        return searchModelArrayList;
    }


}
