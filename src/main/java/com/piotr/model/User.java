package com.piotr.model;

/**
 * Created by jalos on 15.03.2016.
 */
public class User {
    private int id;
    private String imie;
    private String nazwisko;
    private String email;
// w miejscach gdzie dopiero tworze uzytkownika nie ma jeszcze id , dopiero jak bedzie dodany do bazy
    // w formularzu nie bedziemy pytali o id , bo nie bedzie nadany . dopiero jak bedzie zapisany i wyciagniety
    // w id ,  dopiero  2 constrctor  moze  wyciagac wszystkich uzytkownikow, dla tych wszystkich danych potrzebny jest
    // konstruktor z id. stad 2 typy .
    public User(String imie, String nazwisko,String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public User(int id, String imie, String nazwisko, String email) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
