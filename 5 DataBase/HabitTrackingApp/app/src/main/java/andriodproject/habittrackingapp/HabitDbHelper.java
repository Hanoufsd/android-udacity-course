package andriodproject.habittrackingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hanouf on 4/30/17.
 */

/**
 * Database helper for Habits app. Manages database creation and version management.
 */
public class HabitDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habit_tracking.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link HabitDbHelper}.
     *
     * @param context of the app
     */
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the habit table
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_HABIT_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
                + HabitContract.HabitEntry.COLUMN_HABIT_LOCATION_DESC + " TEXT NOT NULL );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
        db.execSQL("DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME);
        onCreate(db);
    }


    public boolean insertHabit(String name, String date, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, name);
        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT_DATE, date);
        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT_LOCATION_DESC, location);
        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * from " + HabitContract.HabitEntry.TABLE_NAME + " WHERE id=" + id, null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, HabitContract.HabitEntry.TABLE_NAME);
        return numRows;
    }

    public boolean updateHabit(int id, String name, String date, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, name);
        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT_DATE, date);
        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT_LOCATION_DESC, location);

        db.update(HabitContract.HabitEntry.TABLE_NAME, contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteHabit(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(HabitContract.HabitEntry.TABLE_NAME, "id = ? ", new String[]{Integer.toString(id)});
    }

    // Delete all Habit table entries
    public int deleteAllHabitEntries() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(HabitContract.HabitEntry.TABLE_NAME, null, null);
    }

    // Delete the whole database
    public boolean deleteDatabase(Context context) {
        return context.deleteDatabase(HabitContract.HabitEntry.TABLE_NAME);
    }

}
