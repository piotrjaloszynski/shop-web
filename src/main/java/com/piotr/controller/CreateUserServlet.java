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

/**
 * Created by jalos on 17.03.2016.
 */
@WebServlet("/user-create")
public class CreateUserServlet extends HttpServlet{
    private UserDao userDao= new UserDao() ;// do user dao  do 3 odnosi
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/user-create.jsp");

  dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 1. odebrac dane z formularza do Post  odebrac dane z formularza za pomoca req.getParamenter

        String imie = req.getParameter("firstname"); // odpowiada form -> name input
        String nazwisko= req.getParameter("lastname");
        String email= req.getParameter("email");

        //2. strworztc obiekt user
        User user= new User(imie,nazwisko,email) ; // dlatego robimy konstruktor.deklaruje zmienna typu user o nazwie user

        // o nazwnie mojpies i tworzy nowy obiekt klasy Pies uzywajac przy tym zmiennych
     //nr 3 ponizej zapisac usera w bazie danych
        try { // try catch wywala wyjatek  , wtedy trzeba try/catch
            userDao.save(user); // przekazujemy uzytkownika ktorego tu zrobilismy do metody zapisu
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/usersListServletMapping");// akcja do ktorej przekierowac uzytkownika
    }

}
