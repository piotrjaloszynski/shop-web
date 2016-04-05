package com.piotr.model;

/**
 * Created by jalos on 26.03.2016.
 */
public class Library {

    private int data_rejestracji;
    private int data_usuniecia;


    private int id;
    private String autor;
    private String tytul;
    private String ISBN;

    public Library(int data_rejestracji, int data_usuniecia, int id, String autor, String ISBN, String tytul) {
        this.data_rejestracji = data_rejestracji;
        this.data_usuniecia = data_usuniecia;
        this.id = id;
        this.autor = autor;
        this.ISBN = ISBN;
        this.tytul = tytul;
    }

    public Library(int data_rejestracji, int data_usuniecia, String autor, String tytul, String ISBN) {
        this.data_rejestracji = data_rejestracji;
        this.data_usuniecia = data_usuniecia;
        this.autor = autor;
        this.tytul = tytul;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Library{" +
                "data_rejestracji=" + data_rejestracji +
                ", data_usuniecia=" + data_usuniecia +
                ", id=" + id +
                ", autor='" + autor + '\'' +
                ", tytul='" + tytul + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public int getData_rejestracji() {
        return data_rejestracji;
    }

    public void setData_rejestracji(int data_rejestracji) {
        this.data_rejestracji = data_rejestracji;
    }

    public int getData_usuniecia() {
        return data_usuniecia;
    }

    public void setData_usuniecia(int data_usuniecia) {
        this.data_usuniecia = data_usuniecia;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
