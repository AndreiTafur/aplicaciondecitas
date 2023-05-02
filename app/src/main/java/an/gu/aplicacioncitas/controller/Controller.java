package an.gu.aplicacioncitas.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import an.gu.aplicacioncitas.config.ADminSQLiteOpenHelper;
import an.gu.aplicacioncitas.modelo.Cita;

public class Controller {
    private String contraseña;

    public Boolean consultUser(String email, String password, ADminSQLiteOpenHelper db) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        String query = "select password from usuario where email=" + "'" + email + "'";
        Cursor fila = sqLiteDatabase.rawQuery(query, null);
        if (fila.moveToFirst()) {
            contraseña = fila.getString(0);
            if (password.equalsIgnoreCase(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public boolean registerUser(String email, String password, ADminSQLiteOpenHelper db) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        sqLiteDatabase.insert("usuario", null, contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public boolean registerAssignation(ADminSQLiteOpenHelper aDminSQLiteOpenHelper, Cita cita) {
        SQLiteDatabase sqLiteDatabase = aDminSQLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cedula", cita.getCedula());
        contentValues.put("nombre", cita.getNombre());
        contentValues.put("telefono", cita.getTelefono());
        contentValues.put("fecha", cita.getFecha());
        contentValues.put("centromedico", cita.getMedico());
        sqLiteDatabase.insert("citasmedicas", null, contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public ArrayList<Cita> listAssignation(ADminSQLiteOpenHelper aDminSQLiteOpenHelper) {
        SQLiteDatabase sqLiteDatabase = aDminSQLiteOpenHelper.getWritableDatabase();
        ArrayList<Cita> list = new ArrayList<>();
        Cita cita = null;
        Cursor citaCursor = null;
        citaCursor = sqLiteDatabase.rawQuery("select * from citasmedicas", null);
        if (citaCursor.moveToFirst()) {
            do {
                cita = new Cita();
                cita.setCedula(citaCursor.getString(0));
                cita.setNombre(citaCursor.getString(1));
                cita.setTelefono(citaCursor.getString(2));
                cita.setFecha(citaCursor.getString(3));
                cita.setMedico(citaCursor.getString(4));
                list.add(cita);
            } while (citaCursor.moveToNext());
        }
        citaCursor.close();
        return list;
    }

}
