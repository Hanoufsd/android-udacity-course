package andriodproject.habittrackingapp;

import android.provider.BaseColumns;

/**
 * Created by Hanouf on 4/30/17.
 */


/**
 * API Contract for the Habit app
 */
public class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {
    }

    /**
     * Inner class that defines constant values for the Habit database table.
     * Each entry in the table represents a single Habit.
     */
    public static final class HabitEntry implements BaseColumns {

        /**
         * Name of database table for habits
         */
        public final static String TABLE_NAME = "habit";

        /**
         * Unique ID number for the habit (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME = "name";

        /**
         * Location of the habit.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_LOCATION_DESC = "location";

        /**
         * Location of the habit.
         * <p>
         * Type: TEXT
         */
        public static final String COLUMN_HABIT_DATE = "date";
    }
}