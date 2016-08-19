package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by drewmahrt on 12/28/15.
 */
public class ShoppingSQLiteOpenHelper extends SQLiteOpenHelper{
    private static final String TAG = ShoppingSQLiteOpenHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "SHOPPING_DB";
    public static final String SHOPPING_LIST_TABLE_NAME = "SHOPPING_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_PRICE = "PRICE";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_TYPE = "TYPE";

        public static final String[] SHOPPING_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_DESCRIPTION,COL_ITEM_PRICE,COL_ITEM_TYPE};
        public static final String[] SHOPPING_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_DESCRIPTION,
                        COL_ITEM_PRICE,COL_ITEM_TYPE};

    private static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + SHOPPING_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_DESCRIPTION + " TEXT, " +
                    COL_ITEM_PRICE + " TEXT, " +
                    COL_ITEM_TYPE + " TEXT )";
        //////////////////////////////////////////////////////
                private static ShoppingSQLiteOpenHelper mInstance;

                public static ShoppingSQLiteOpenHelper getInstance(Context context) {
                if (mInstance == null) {
                        mInstance = new ShoppingSQLiteOpenHelper(context.getApplicationContext());
                    }

                        return mInstance;
            }

                //////////////////////////////////////////////////////

    public ShoppingSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        public Cursor searchShoppingList(String query){

            return cursor;
        }

                    public String getDescriptionById(int id){
                    SQLiteDatabase db = this.getReadableDatabase();

                            Cursor cursor = db.query(SHOPPING_LIST_TABLE_NAME,
                                    new String[]{COL_ITEM_DESCRIPTION},
                                    COL_ID+" = ?",
                                    new String[]{String.valueOf(id)},
                                    null,
                                    null,
                                    null,
                                    null);

                            if(cursor.moveToFirst()){
                           return cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
                        } else {
                            return "No Description Found";
                        }
                }
    }