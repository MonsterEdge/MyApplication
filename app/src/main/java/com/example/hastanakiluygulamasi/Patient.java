package com.example.hastanakiluygulamasi;

import com.example.hastanakiluygulamasi;.Patient;
public class Patient {
    // Hasta özelliklerini tanımlayan değişkenler
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String bloodType;
    private String disease;
    private String transferStatus;

    // Hasta sınıfının kurucu metodu
    public Patient(String name, String surname, int age, String gender, String bloodType, String disease, String transferStatus) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
        this.disease = disease;
        this.transferStatus = transferStatus;
    }

    // Hasta özelliklerine erişmek ve değiştirmek için getter ve setter metodları
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    // Hasta nesnesini metin olarak döndüren toString() metodu
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", disease='" + disease + '\'' +
                ", transferStatus='" + transferStatus + '\'' +
                '}';
    }

    // Hasta nesnelerinin eşitliğini kontrol eden equals() metodu
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age &&
                name.equals(patient.name) &&
                surname.equals(patient.surname) &&
                gender.equals(patient.gender) &&
                bloodType.equals(patient.bloodType) &&
                disease.equals(patient.disease) &&
                transferStatus.equals(patient.transferStatus);
    }
}
