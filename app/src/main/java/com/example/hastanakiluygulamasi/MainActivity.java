package com.example.hastanakiluygulamasi;
import com.example.hastanakiluygulamasi.DatabaseHelper;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.DatePicker;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity {

    //Arayüz elemanlarını tanımlayalım
    EditText et_hasta_adi, et_hasta_soyadi, et_hasta_tc, et_hasta_dogum, et_tesis_adi, et_tesis_adres, et_tesis_telefon, et_nakil_tarih;
    RadioGroup rg_hasta_cinsiyet;
    RadioButton rb_hasta_erkek, rb_hasta_kadin;
    Spinner sp_hasta_kan;
    Button btn_kaydet;

    //Veritabanı yardımcı sınıfını tanımlayalım
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Arayüz elemanlarını id'lerine göre bağlayalım
        et_hasta_adi = findViewById(R.id.et_hasta_adi);
        et_hasta_soyadi = findViewById(R.id.et_hasta_soyadi);
        et_hasta_tc = findViewById(R.id.et_hasta_tc);
        et_hasta_dogum = findViewById(R.id.et_hasta_dogum);
        rg_hasta_cinsiyet = findViewById(R.id.rg_hasta_cinsiyet);
        rb_hasta_erkek = findViewById(R.id.rb_hasta_erkek);
        rb_hasta_kadin = findViewById(R.id.rb_hasta_kadin);
        sp_hasta_kan = findViewById(R.id.sp_hasta_kan);
        et_tesis_adi = findViewById(R.id.et_tesis_adi);
        et_tesis_adres = findViewById(R.id.et_tesis_adres);
        et_tesis_telefon = findViewById(R.id.et_tesis_telefon);
        et_nakil_tarih = findViewById(R.id.et_nakil_tarih);
        btn_kaydet = findViewById(R.id.btn_kaydet);

        //Veritabanı yardımcı sınıfını oluşturalım
        databaseHelper = new DatabaseHelper(this);

        //Kaydet butonuna tıklandığında
        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Metin kutularından alınan bilgileri değişkenlere atayalım
                String hasta_adi = et_hasta_adi.getText().toString();
                String hasta_soyadi = et_hasta_soyadi.getText().toString();
                String hasta_tc = et_hasta_tc.getText().toString();
                String hasta_dogum = et_hasta_dogum.getText().toString();
                String hasta_cinsiyet = "";
                if (rb_hasta_erkek.isChecked()) {
                    hasta_cinsiyet = "Erkek";
                } else if (rb_hasta_kadin.isChecked()) {
                    hasta_cinsiyet = "Kadın";
                }
                String hasta_kan = sp_hasta_kan.getSelectedItem().toString();
                String tesis_adi = et_tesis_adi.getText().toString();
                String tesis_adres = et_tesis_adres.getText().toString();
                String tesis_telefon = et_tesis_telefon.getText().toString();
                String nakil_tarih = et_nakil_tarih.getText().toString();

                //Bilgilerin boş olup olmadığını kontrol edelim
                if (hasta_adi.isEmpty() || hasta_soyadi.isEmpty() || hasta_tc.isEmpty() || hasta_dogum.isEmpty() || hasta_cinsiyet.isEmpty() || hasta_kan.isEmpty() || tesis_adi.isEmpty() || tesis_adres.isEmpty() || tesis_telefon.isEmpty() || nakil_tarih.isEmpty()) {
                    //Eğer boş bilgi varsa, Toast mesajı ile uyarı verelim
                    Toast.makeText(MainActivity.this, "Lütfen tüm bilgileri giriniz", Toast.LENGTH_SHORT).show();
                } else {
                    //Eğer boş bilgi yoksa, veritabanına kaydetmek için ContentValues nesnesi oluşturalım
                    ContentValues contentValues = new ContentValues();
                    //Bu nesneye, veritabanındaki sütun adları ve karşılık gelen değerleri ekleyelim
                    contentValues.put("hasta_adi", hasta_adi);
                    contentValues.put("hasta_soyadi", hasta_soyadi);
                    contentValues.put("hasta_tc", hasta_tc);
                    contentValues.put("hasta_dogum", hasta_dogum);
                    contentValues.put("hasta_cinsiyet", hasta_cinsiyet);
                    contentValues.put("hasta_kan", hasta_kan);
                    contentValues.put("tesis_adi", tesis_adi);
                    contentValues.put("tesis_adres", tesis_adres);
                    contentValues.put("tesis_telefon", tesis_telefon);
                    contentValues.put("nakil_tarih", nakil_tarih);

                    //Veritabanına yazılabilir bağlantı alalım
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    //Veritabanına bilgileri kaydedelim
                    long result = db.insert("hasta_nakil", null, contentValues);
                    //Kaydetme işleminin başarılı olup olmadığını kontrol edelim
                    if (result == -1) {
                        //Eğer başarısız olursa, Toast mesajı ile hata verelim
                        Toast.makeText(MainActivity.this, "Bilgiler kaydedilemedi", Toast.LENGTH_SHORT).show();
                    } else {
                        //Eğer başarılı olursa, Toast mesajı ile başarıyı bildirelim
                        Toast.makeText(MainActivity.this, "Bilgiler başarıyla kaydedildi", Toast.LENGTH_SHORT).show();
                        //Metin kutularını temizleyelim
                        et_hasta_adi.setText("");
                        et_hasta_soyadi.setText("");
                        et_hasta_tc.setText("");
                        et_hasta_dogum.setText("");
                        rg_hasta_cinsiyet.clearCheck();
                        sp_hasta_kan.setSelection(0);
                        et_tesis_adi.setText("");
                        et_tesis_adres.setText("");
                        et_tesis_telefon.setText("");
                        et_nakil_tarih.setText("");
                    }
                }
            }
        });
    }
}
