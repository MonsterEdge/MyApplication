package com.example.hastanakiluygulamasi;

// Gerekli paketleri ve sınıfları içe aktarıyoruz
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class PatientFormActivity extends AppCompatActivity {

    // Arayüz bileşenlerini tanımlıyoruz
    EditText editName, editSurname, editAge, editDisease;
    Spinner spinnerGender, spinnerBloodType;
    RadioButton radioYes, radioNo;
    Button buttonSave;

    // Veritabanı yardımcı sınıfını tanımlıyoruz
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Arayüz olarak patient_form.xml dosyasını belirliyoruz
        setContentView(R.layout.patient_form);

        // Arayüz bileşenlerini tanımladığımız değişkenlere atıyoruz
        editName = findViewById(R.id.patient_name);
        editSurname = findViewById(R.id.patient_surname);
        editAge = findViewById(R.id.patient_age);
        editDisease = findViewById(R.id.patient_disease);
        spinnerGender = findViewById(R.id.patient_gender);
        spinnerBloodType = findViewById(R.id.patient_blood_type);
        radioYes = findViewById(R.id.patient_transfer_status_yes);
        radioNo = findViewById(R.id.patient_transfer_status_no);
        buttonSave = findViewById(R.id.patient_save_button);

        // Veritabanı yardımcı sınıfını oluşturuyoruz
        databaseHelper = new DatabaseHelper(this);

        // Button bileşenine bir tıklama dinleyicisi atıyoruz
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tıklama olduğunda, arayüz bileşenlerinden hasta bilgilerini alıyoruz
                String name = editName.getText().toString();
                String surname = editSurname.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());
                String disease = editDisease.getText().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String bloodType = spinnerBloodType.getSelectedItem().toString();
                String transferStatus = radioYes.isChecked() ? "Evet" : "Hayır";

                // Hasta bilgilerini kullanarak bir hasta nesnesi oluşturuyoruz
                Patient patient = new Patient(name, surname, age, gender, bloodType, disease, transferStatus);

                // Veritabanı yardımcı sınıfını kullanarak hasta nesnesini veritabanına kaydediyoruz
                boolean result = databaseHelper.insertPatient(patient);

                // Kaydetme işleminin sonucuna göre bir Toast mesajı gösteriyoruz
                if (result) {
                    Toast.makeText(PatientFormActivity.this, "Hasta bilgileri başarıyla kaydedildi.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PatientFormActivity.this, "Hasta bilgileri kaydedilemedi.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
