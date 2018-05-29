package com.unilab.workplace.database.table;

import android.content.Context;

import com.unilab.workplace.database.Table;

/**
 * Created by c_alraygon on 11/7/2016.
 */
public class SubCatTable extends Table{

    Context context;
    public final static String TABLE_NAME = "sub_cat_tbl";
    //DATABASE COLUMNS
    public final static String ID = "id";
    public final static String DESCRIPTION = "description";
    public final static String MAIN_CAT_ID = "main_cat_id";
    public final static String TITLE_SEC_DESC = "title_sec_desc";
    public final static String CONTENT_IMG = "content_img";
//    public final static String EMP_READTERMS = "emp_readterms";
//    public final static String EMP_MODIFIED = "emp_modified";

    public SubCatTable(Context context){
        this.context = context;
    }
    public final static String TABLE_STRUCTURE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " TEXT" + DESCRIPTION
            + " TEXT " + MAIN_CAT_ID + " TEXT" + TITLE_SEC_DESC + " TEXT" + CONTENT_IMG + " TEXT" +");";

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
}
