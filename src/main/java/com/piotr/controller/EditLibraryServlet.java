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

/**
 * Created by jalos on 03.04.2016.
 */

   @WebServlet("/library-edit")

   public class EditLibraryServlet extends HttpServlet{

private LibraryDao libraryDao= new LibraryDao();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id= Integer.parseInt(req.getParameter("id"));
           Library library= null;// przekaze
            try {
                library = libraryDao.findById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("library",library);
            RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/library-edit.jsp");
// nie wystarczy samo przekierowanie na user edit  uzywamy tag dolar ,  $ do danych 2 linijki ktore przekierowuja , trzeba
            // ustawic atrybut.  req.SetAtribute  zmienna typu user jako atrubyt ty odwolujac sie do user.imie odwoluje
            // sie do obiektu ${user.imie)z user edit.
            //User user = new User()
            // hiden input ktos nam wysyla id ktos o tym nie wie, ale komputer to sam robi.

            dispatcher.forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String autor = req.getParameter("autor"); // odpowiada form -> name input
            String tytul= req.getParameter("tytul");
            String ISBN= req.getParameter("ISBN");

            int data_usuniecia=Integer.parseInt("data_usuniecia");
            //int data_usuniecia=req.getParameter("data_usuniecia");
            int data_rejestracji=Integer.parseInt("data_rejestracji");
           // int data_rejestracji=req.getParameter("data_rejestracji");

            int id = Integer.parseInt(req.getParameter("id")); // dokladnie wpisalimy co w przy atrybucie namie , user-edit.servlet
            // parse int nie mogl  zparsowac na inta.dlatego aplikacja sie wysypala
            Library library= new Library( data_rejestracji, data_usuniecia, id, autor, ISBN, tytul);
            try {
                libraryDao.update(library); //todo Sprawdzic z wojtkiem  bylo userDao
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/librariesListServletMapping");
        }

}
