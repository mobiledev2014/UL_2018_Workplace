package com.unilab.workplace.database.table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.unilab.workplace.database.Table;
import com.unilab.workplace.database.model.EmpModel;

import java.util.ArrayList;


public class EmpTable extends Table {

    Context context;
    public final static String TABLE_NAME = "emp_info_tbl";
    //DATABASE COLUMNS
    public final static String _ID = "_id";
    public final static String EMP_ID = "emp_id";
    public final static String EMP_BIRTHDATE = "emp_birthdate";
    public final static String STATUS = "status";
    public final static String EMP_CREATED = "emp_created";
    public final static String EMP_AGREEDTERMS = "emp_agreement";
    public final static String EMP_READTERMS = "emp_readterms";
    public final static String EMP_MODIFIED = "emp_modified";


    public final static String TABLE_STRUCTURE = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMP_ID
            + " TEXT " + EMP_BIRTHDATE + " TEXT" + STATUS + " TEXT" + EMP_CREATED + " TEXT" + EMP_AGREEDTERMS + " TEXT" + EMP_READTERMS + " TEXT" + EMP_MODIFIED + " TEXT" + ");";

    public final static String TAG = "EmpTable";


    public EmpTable(Context context) {
        this.context = context;
    }

    @Override
    public String getTableStructure() {
        // TODO Auto-generated method stub
        return TABLE_STRUCTURE;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return TABLE_NAME;
    }

//    ArrayList<EmpTable> getAllEmpInfo(String emp_id) {
//        ArrayList<EmpTable> arr_info = new ArrayList<EmpTable>();
//
//
//        String query = "SELECT * FROM " + getName() + " WHERE " + EMP_ID
//                + " = '" + emp_id + "'";
//
//        Cursor cursor = rawQuery(query, null);
//        boolean emp;
//        if (cursor != null) {
//            if (cursor.getCount() > 0) {
//
//                emp = true;
//
//            } else {
//                emp = false;
//            }
//
//        } else {
//            emp = false;
//        }
//        return   "";
//
//
//    }


    // get data from sql lite

    public boolean getUserCredentials(String emp_id) {

        String query = "SELECT * FROM " + getName() + " WHERE " + EMP_ID
                + " = '" + emp_id + "'";
        Cursor cursor = rawQuery(query, null);
        boolean result;
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;

    }

    public void addUser(String emp_id, String birthdate, String status, String emp_created,
                        String agreedTerms, String emp_readTerms, String emp_modified, String _id) {

        ContentValues values = new ContentValues();
        values.put(_ID, _id);
        values.put(EMP_ID, emp_id);
        values.put(EMP_BIRTHDATE, birthdate);
        values.put(STATUS, status);
        values.put(EMP_CREATED, emp_created);
        values.put(EMP_AGREEDTERMS, agreedTerms);
        values.put(EMP_READTERMS, emp_readTerms);
        values.put(EMP_MODIFIED, emp_modified);

        insert(values);

//        update(values,"emp_agreement="+agreedTerms,null);
//        update(values,"emp_readterms="+emp_readTerms,null);

    }

    //update a column
    public void updateEmpModified(String emp_modified, String emp_id) {

        ContentValues values = new ContentValues();
        values.put(EMP_MODIFIED, emp_modified);
//        Log.d(TAG,"Saving User:"+emp_id+" last login:"+emp_modified);
        insertOrUpdate(values, EMP_ID + " = '" + emp_id + "'");
    }

    //    //update specific column in employee per emp_id
//    public void updateEmp_Specifics(String columnNameToPut,String putValue,String whereColumnName,String filterValue) {
//
//        ContentValues values = new ContentValues();
//        values.put(columnNameToPut, putValue);
//        Log.d(TAG,"Saving User:"+filterValue+" emp_agreed:"+putValue);
//        insertOrUpdate(values,whereColumnName + " = '" + filterValue + "'");
//    }
    //update a column
    public void updateEmp_Specifics(String emp_agreementValue, String whereEmp) {

        ContentValues values = new ContentValues();
        values.put(EMP_AGREEDTERMS, emp_agreementValue);
        Log.d(TAG,"Updating User:"+whereEmp+" agreement:"+emp_agreementValue);
        insertOrUpdate(values, EMP_ID + " = '" + whereEmp + "'");
    }

    public int getCount() {
        return rawQuery("SELECT * FROM " + TABLE_NAME, null).getCount();
    }

    public String getDateModified(String emp_id) {
        String t = null;
        String query = "SELECT * FROM " + getName() + " WHERE " + EMP_ID
                + " = '" + emp_id + "'";

        SQLiteDatabase db = this.getReadableDB();

        try {

            Cursor cursor = db.rawQuery(query, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Log.i("EmpTable", "" + cursor.getString(cursor.getColumnIndex(EMP_MODIFIED)) + "-" + cursor.getColumnIndex(EMP_MODIFIED));
                        t = cursor.getString(cursor.getColumnIndex(EMP_MODIFIED));
                        //obj.setEmp_id(cursor.getString(cursor.getColumnIndex(EMP_ID)));

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
        return t;
    }

    public String getEmp_Agreement(String emp_id) {
        String t = null;
        String query = "SELECT * FROM " + getName() + " WHERE " + EMP_ID
                + " = '" + emp_id + "'";

        SQLiteDatabase db = this.getReadableDB();

        try {

            Cursor cursor = db.rawQuery(query, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
//                        Log.i("EmpTable","EMP_AGREEDTERMS:"+cursor.getString(cursor.getColumnIndex(EMP_AGREEDTERMS))+"-"+cursor.getColumnIndex(EMP_AGREEDTERMS));
                        t = cursor.getString(cursor.getColumnIndex(EMP_AGREEDTERMS));
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
        return t;
    }

    //get birthdate
    public String getEmp_Birthdate(String emp_id) {
        String t = null;
        String query = "SELECT * FROM " + getName() + " WHERE " + EMP_ID
                + " = '" + emp_id + "'";

        SQLiteDatabase db = this.getReadableDB();

        try {

            Cursor cursor = db.rawQuery(query, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
//                        Log.i("EmpTable","EMP_AGREEDTERMS:"+cursor.getString(cursor.getColumnIndex(EMP_AGREEDTERMS))+"-"+cursor.getColumnIndex(EMP_AGREEDTERMS));
                        t = cursor.getString(cursor.getColumnIndex(EMP_BIRTHDATE));
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
        return t;
    }

    public ArrayList<EmpModel> getAllElements() {

        ArrayList<EmpModel> empList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDB();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        EmpModel obj = new EmpModel();
                        //column
                        obj.setEmp_id(cursor.getString(cursor.getColumnIndex(EMP_ID)));
                        obj.setEmp_birthdate(cursor.getString(cursor.getColumnIndex(EMP_BIRTHDATE)));
                        obj.setStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
                        obj.setEmp_created(cursor.getString(cursor.getColumnIndex(EMP_CREATED)));
                        obj.setEmp_agreement(cursor.getString(cursor.getColumnIndex(EMP_AGREEDTERMS)));
                        obj.setEmp_readterms(cursor.getString(cursor.getColumnIndex(EMP_READTERMS)));
                        obj.setEmp_modified(cursor.getString(cursor.getColumnIndex(EMP_MODIFIED)));
                        obj.set_id(cursor.getString(cursor.getColumnIndex(_ID)));
                        empList.add(obj);
//                        Log.i("EmpTable","Employee:"+empList.toString()+"\n");
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

        return empList;
    }
}
