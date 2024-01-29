package com.example.hastanakiluygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Veritabanı adı ve sürümü sabitleri tanımlayalım
    public static final String DB_NAME = "hasta_nakil.db";
    public static final int DB_VERSION = 1;

    //Veritabanı tablo adı ve sütun adları sabitleri tanımlayalım
    private static final String TABLE_NAME = "hasta_nakil";
    private static final String COL_ID = "_id";
    private static final String COL_HASTA_ADI = "hasta_adi";
    private static final String COL_HASTA_SOYADI = "hasta_soyadi";
    private static final String COL_HASTA_TC = "hasta_tc";
    private static final String COL_HASTA_DOGUM = "hasta_dogum";
    private static final String COL_HASTA_CINSIYET = "hasta_cinsiyet";
    private static final String COL_HASTA_KAN = "hasta_kan";
    private static final String COL_TESIS_ADI = "tesis_adi";
    private static final String COL_TESIS_ADRES = "tesis_adres";
    private static final String COL_TESIS_TELEFON = "tesis_telefon";
    private static final String COL_NAKIL_TARIH = "nakil_tarih";

    //Veritabanı oluşturma sorgusu sabiti tanımlayalım
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_HASTA_ADI + " TEXT NOT NULL, " +
            COL_HASTA_SOYADI + " TEXT NOT NULL, " +
            COL_HASTA_TC + " TEXT NOT NULL, " +
            COL_HASTA_DOGUM + " TEXT NOT NULL, " +
            COL_HASTA_CINSIYET + " TEXT NOT NULL, " +
            COL_HASTA_KAN + " TEXT NOT NULL, " +
            COL_TESIS_ADI + " TEXT NOT NULL, " +
            COL_TESIS_ADRES + " TEXT NOT NULL, " +
            COL_TESIS_TELEFON + " TEXT NOT NULL, " +
            COL_NAKIL_TARIH + " TEXT NOT NULL);";

    //Yapıcı metod tanımlayalım
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Veritabanı oluşturma metodunu tanımlayalım
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Veritabanı oluşturma sorgusunu çalıştıralım
        db.execSQL(CREATE_TABLE);
    }

    //Veritabanı güncelleme metodunu tanımlayalım
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Veritabanı tablosunu silme sorgusunu çalıştıralım
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //Veritabanı oluşturma metodunu çağıralım
        onCreate(db);
    }
}
