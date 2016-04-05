

package com.piotr.dao;


import java.sql.Connection;

import com.piotr.config.Database;
import com.piotr.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


 //Created by jalos on 16.03.2016.



public class UserDao {
// brakuje findById(int id ) throws SQLException
    private Database database = new Database();
    public User findById(int id) throws SQLException {
        User user = null;// user zaznaczony jako null zeby pozniej ustawic , user = new User (id,ime..nazw,email
        Connection conn = database.getConn(); // do bazy zapytania , findid znajdzie uzytkownika ktory mial byc znaleziony
        // jak wpiszemy uzytkowniak
        PreparedStatement statement = conn.prepareStatement("Select id,imie,nazwisko,email FROM user WHERE id=? ");
        // pierwszy znak zapytania,
        statement.setInt(1,id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String imie = result.getString("imie");
            String nazwisko = result.getString("nazwisko");
            String email = result.getString("email");
            user = new User(id, imie, nazwisko, email);// jesli nie znajdziesz takiego uzytkownika o id to nie zwraca null
        }
        return user;
    }

    public void update(User user) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("Update user SET  imie=?, nazwisko=?, email=? WHERE id=?");
        // pierwszy znak dla ktorego robimy pytanie to imie .stad stateme.nt  dla imienia

        statement.setString(1, user.getImie());
        statement.setString(2, user.getNazwisko());
        statement.setString(3, user.getEmail());
        statement.setInt(4, user.getId()); // liczac od poczatku zapytania przy id jest 4 znak
        statement.executeUpdate();

    }

    public void delete(User user) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("DELETE  FROM user WHERE id=?"); // po to ? zeby moc sparametryzowac
        // zeby byla ciagle uzyteczna , jakbym  napisal  WHERE id= 1 to zawsze tylko nr 1 !
        statement.setInt(1, user.getId());
        // statement.setString(2,user.getNazwisko());
        //statement.setString(3, user.getEmail());
        statement.executeUpdate();// metoda zmieni cos  bylo 10 a jest 7, jezeli pworwadze zmian to excecute update. zamiast
        //excetuteQuery
    }
public List<User> findAll() throws SQLException {
    // my chcemy  wszystkich dlatego  zwracamy w formie listy
    List<User> users= new ArrayList<>();// ostry mowi ze to typ paramentryczny ktory ma podany paramentr i okralgy ktory sugeruje ze konstruktor
// zmienna lokalna tej funkcji  na nic innego oprocz tej liniji nie ma wspolnego bede musial po
    //prawic w tej linijce
    Connection conn=database.getConn();
    PreparedStatement statement =conn.prepareStatement(" Select *FROM  user ");
    // nie ma znakow zapytania stad nie ustawiam  statement.setInt() stad znak zapytania  jakby byl?
    ResultSet result = statement.executeQuery(); // select nie zmienia struktury bazy , nic nie usuwa nie dodaje , wyciagamy tylko dane., selext
    // zwraca cos


    while (result.next()) {
        int id= result.getInt("id");// string ma byc w nawiasie funkcji
        String imie = result.getString("imie");
        String nazwisko = result.getString("nazwisko");
        String email = result.getString("email");
        User user = new User(id, imie, nazwisko, email);// jesli nie znajdziesz takiego uzytkownika o id to nie zwraca null
        users.add(user);// wywolanie metydoy stad raz user,  tworzenie User user
    }
    return users;
}
    public void deleteById (int id) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("DELETE  FROM user WHERE id=?");
       statement.setInt(1, id); //wczesniej pobrac a teraz bezposrednio w parametrze

        statement.executeUpdate();
    }


    // ZAPYTANIE W SQL  NAZYWA SIE INSERT INTO
public void save(User user) throws SQLException {
    Connection conn = database.getConn();
    PreparedStatement statement = conn.prepareStatement("iNSERT INTO user (id,imie,nazwisko,email) values ( ?,?,?,?) "); // po to ? zeby moc sparametryzowac
    // zeby byla ciagle uzyteczna , jakbym  napisal  WHERE id= 1 to zawsze tylko nr 1 !
    statement.setInt(1, user.getId());
    statement.setString(2,user.getImie());
    statement.setString(3, user.getNazwisko());
    statement.setString(4,user.getEmail());
    statement.executeUpdate();

}
}

