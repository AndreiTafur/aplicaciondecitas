package an.gu.aplicacioncitas.config;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ADminSQLiteOpenHelper extends SQLiteOpenHelper {



    public ADminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuario(email text primary key,password text)");
        sqLiteDatabase.execSQL("create table citasmedicas(cedula text primary key,nombre text,telefono text,fecha text,centromedico text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP table IF EXISTS usuario");
        sqLiteDatabase.execSQL("DROP table IF EXISTS citasmedicas");
    }
}
