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
 * Created by jalos on 24.03.2016.
 */
@WebServlet("/user-edit")
public class EditUserServlet extends HttpServlet{
    private UserDao userDao= new UserDao() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     int id= Integer.parseInt(req.getParameter("id"));
        User user= null;// przekaze
        try {
            user = userDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("user",user);
        RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/user-edit.jsp");
// nie wystarczy samo przekierowanie na user edit  uzywamy tag dolar ,  $ do danych 2 linijki ktore przekierowuja , trzeba
        // ustawic atrybut.  req.SetAtribute  zmienna typu user jako atrubyt ty odwolujac sie do user.imie odwoluje
        // sie do obiektu ${user.imie)z user edit.
        //User user = new User()
        // hiden input ktos nam wysyla id ktos o tym nie wie, ale komputer to sam robi.

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imie = req.getParameter("firstname"); // odpowiada form -> name input
        String nazwisko= req.getParameter("lastname");
        String email= req.getParameter("email");

        int id = Integer.parseInt(req.getParameter("id")); // dokladnie wpisalimy co w przy atrybucie namie , user-edit.servlet
        // parse int nie mogl  zparsowac na inta.dlatego aplikacja sie wysypala
        User user= new User(id,imie,nazwisko,email);
        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/usersListServletMapping");
    }
}
