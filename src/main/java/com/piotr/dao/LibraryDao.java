package com.piotr.dao;


import com.piotr.config.Database;
import com.piotr.model.Library;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalos on 26.03.2016.
 */
public class LibraryDao {
    private Database database = new Database();

    public Library findById(int id) throws SQLException {
        Library library = null;
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("Select id,autor,tytul,ISBN,data_usuniecia,data_rejestracji FROM library WHERE id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String autor = result.getString("autor");
            String tytul = result.getString("tytul");
            String ISBN = result.getString("ISBN");
            int data_usuniecia = result.getInt("data_usuniecia");
            int data_rejestracji = result.getInt("data_rejestracji");
            library = new Library( data_rejestracji,data_usuniecia,id,autor, ISBN, tytul);// jesli nie znajdziesz takiego uzytkownika o id to nie zwraca null
        }
        //  PATRZ NA KONSTRUKTOR  W LIBRABRY DEF. KONSTRUKT
        // A W KLASIE IBRARY DAO CHCE SKORZYSTAC
        return library;

    }

    public void update(Library library) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("Update library SET  autor=?, tytul=?, ISBN=? WHERE id=?");


        statement.setString(1, library.getAutor());//todo sprawdzic z Wojtkiem dlaczego todo
        statement.setString(2, library.getTytul());
        statement.setString(3, library.getISBN());
        statement.setInt(4, library.getId());
        statement.executeUpdate();
    }

    public void delete(Library library) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("DELETE  FROM library WHERE id=? and tytul=?"); // po to ? zeby moc sparametryzowac
        // zeby byla ciagle uzyteczna , jakbym  napisal  WHERE id= 1 to zawsze tylko nr 1 !

        //int id= result.getInt("id");
        statement.setInt(1, library.getId());
        statement.setString(2, library.getTytul());//todo sprawdzic z Wojtkiem dla get tytul
        // statement.setString(2,user.getNazwisko());
        //statement.setString(3, user.getEmail());
        statement.executeUpdate();// metoda zmieni cos  bylo 10 a jest 7, jezeli pworwadze zmian to excecute update. zamiast
        //excetuteQuery

    }

    public List<Library> findAll() throws SQLException {
        // my chcemy  wszystkich dlatego  zwracamy w formie listy
        List<Library> libraries = new ArrayList<>();// ostry mowi ze to typ paramentryczny ktory ma podany paramentr i okralgy ktory sugeruje ze konstruktor
// zmienna lokalna tej funkcji  na nic innego oprocz tej liniji nie ma wspolnego bede musial po
        //prawic w tej linijce
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement(" Select *FROM  library ");
        // nie ma znakow zapytania stad nie ustawiam  statement.setInt() stad znak zapytania  jakby byl?
        ResultSet result = statement.executeQuery(); // select nie zmienia struktury bazy , nic nie usuwa nie dodaje , wyciagamy tylko dane., selext
        // zwraca cos


        while (result.next()) {
            int id = result.getInt("id");// string ma byc w nawiasie funkcji
            String autor = result.getString("autor");
            String tytul = result.getString("tytul");
            String ISBN = result.getString("ISBN");
            int data_usuniecia = result.getInt("data_usuniecia");
            int  data_rejestracji = result.getInt("data_rejestracji");
            Library library = new Library( data_rejestracji,  data_usuniecia,  id,  autor, ISBN,  tytul);// jesli nie znajdziesz takiego uzytkownika o id to nie zwraca null
            libraries.add(library);// wywolanie metydoy stad raz user,  tworzenie User user
        }
        return libraries;
    }

    public void deleteById(int id) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("DELETE  FROM library WHERE id=?");
        statement.setInt(1, id); //wczesniej pobrac a teraz bezposrednio w parametrze

        statement.executeUpdate();

    }

    // ZAPYTANIE W SQL  NAZYWA SIE INSERT INTO
    public void save(Library library) throws SQLException {
        Connection conn = database.getConn();
        PreparedStatement statement = conn.prepareStatement("iNSERT INTO library (id,autor,tytul,ISBN, data_usuniecia, data_rejestracji) values ( ?,?,?,?,?,?) "); // po to ? zeby moc sparametryzowac
        // zeby byla ciagle uzyteczna , jakbym  napisal  WHERE id= 1 to zawsze tylko nr 1 !
        statement.setInt(1, library.getId());
        statement.setString(2, library.getAutor());
        statement.setString(3, library.getTytul());
        statement.setString(4, library.getISBN());
        statement.setInt(5, library.getData_usuniecia());
        statement.setInt(6, library.getData_rejestracji());
        statement.executeUpdate();
    }
}