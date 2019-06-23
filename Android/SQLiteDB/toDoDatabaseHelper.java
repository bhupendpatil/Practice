package tk.bhupend.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class toDoDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "todoList.db";
    private static final int DATABASE_VERSION = 1;

    public toDoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE ToDo (task TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ToDo");
        onCreate(db);
    }

    public void addTask(String item){
        ContentValues values = new ContentValues();
        values.put("task", item);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("ToDo", null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteTask(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM ToDo where task='"+item+"'");
    }

    public void updateTask(String oldvalue, String newvalue){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("task", newvalue);
            db.update("ToDo", contentValues, "task='"+oldvalue +"'", null);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllTasks() {
        ArrayList<String> contactList = new ArrayList<String>();
        String selectQuery = "SELECT * FROM ToDo";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                contactList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public ArrayList<String> getTaskByItem(int item) {
        ArrayList<String> contactList = new ArrayList<String>();
        String selectQuery = "SELECT * FROM ToDo where task=" +item;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            contactList.add(cursor.getString(1));
        }
        return contactList;
    }
}