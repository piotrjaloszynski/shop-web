package com.piotr.controller;

import com.piotr.dao.LibraryDao;

import com.piotr.model.Library;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jalos on 03.04.2016.
 */



    @WebServlet("/libraryServletMapping") // wyslanie rzadania get na adres / users bedzie oznaczalo ze ma pobrac wszystkich uzytkownikow
    public class LibraryServlet extends HttpServlet {

        private LibraryDao libraryDao= new LibraryDao() ;// do user dao

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Library> libraries= null;// wybierz wszystkich uzytkownikow z bazy danych select *
            try {
                libraries = libraryDao.findAll();
            } catch (SQLException e) {
                e.printStackTrace();// mamy wyjatki i zawsze powinnismy zrobic try/catch
            }
            // dodalem do usera constr i zaczelo  users.add(new User()); // dodales pustego uzytkownia bez danych , teraz mamy w user w modelu
  /*  List<User> users= new ArrayList<>();
  users.add(new User("Jan", "NOWAK", "NOWAK@WP.PL")); // stuczna lista zeby dzialalo bo nie mielismy tabelek
        users.add(new User("Pawel"," Smith","smith@wp.pl"));
        users.add(new User("Paw", "Jole","jole@wp.pl"));*/
            req.setAttribute("librariesLoop",libraries); // tutaj dokladnie  ta nazwa dla petli for each   dodajemy atrubyt  bedzie obslugiwany dodajemy requesta i przesylamy do strony jsp
            RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/library-list.jsp");
            dispatcher.forward(req, resp);// dodalismy atrubut do requesta i przekazejmy dalej w tym przypadku strone jsp
        }
    }
