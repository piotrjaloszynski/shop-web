package com.piotr.controller;

import com.piotr.dao.UserDao;
import com.piotr.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// mamy CALA LISTE UZYTKOWNIKOW.  JEST METODA  FINDall metoda dlatego !!!!!!! pamietac w EditUserServlet
/**
 * Created by jalos on 16.03.2016.
 */
@WebServlet("/usersListServletMapping") // wyslanie rzadania get na adres / users bedzie oznaczalo ze ma pobrac wszystkich uzytkownikow
public class UserServlet extends HttpServlet{

    private UserDao userDao= new UserDao() ;// do user dao

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User>users= null;// wybierz wszystkich uzytkownikow z bazy danych select *
        try {
            users = userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();// mamy wyjatki i zawsze powinnismy zrobic try/catch
        }
        // dodalem do usera constr i zaczelo  users.add(new User()); // dodales pustego uzytkownia bez danych , teraz mamy w user w modelu
  /*  List<User> users= new ArrayList<>();
  users.add(new User("Jan", "NOWAK", "NOWAK@WP.PL")); // stuczna lista zeby dzialalo bo nie mielismy tabelek
        users.add(new User("Pawel"," Smith","smith@wp.pl"));
        users.add(new User("Paw", "Jole","jole@wp.pl"));*/
   req.setAttribute("usersLoop",users); // tutaj dokladnie  ta nazwa dla petli for each   dodajemy atrubyt  bedzie obslugiwany dodajemy requesta i przesylamy do strony jsp
        RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/user-list.jsp");
        dispatcher.forward(req, resp);// dodalismy atrubut do requesta i przekazejmy dalej w tym przypadku strone jsp
    }
}
