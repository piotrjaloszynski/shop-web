package com.piotr.controller;

import com.piotr.dao.LibraryDao;
import com.piotr.model.Library;
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
 * Created by jalos on 03.04.2016.
 */

@WebServlet("/library-create")
public class CreateLibraryServlet extends HttpServlet{

    private LibraryDao libraryDao= new LibraryDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/library-create.jsp");
        dispatcher.forward(req,resp);
        // forward oznacza przekieruj request do zasobu ktory jest w cudzyslowiu
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. odebrac dane z formularza do Post  odebrac dane z formularza za pomoca req.getParamenter
        // nie mozna dolozyc ID  poniewaz nie znamy ID .
        String autor = req.getParameter("autor"); // odpowiada form -> name input
        String tytul= req.getParameter("tytul");
        String ISBN= req.getParameter("ISBN");
       // Int data_usuniecia=req.getParameter("data_usuniecia");
        int data_usuniecia= Integer.parseInt(req.getParameter("data_usuniecia"));
        //Int data_rejestracji=req.getParameter("data_rejestracji");
        int data_rejestracji= Integer.parseInt(req.getParameter("data_rejestracji"));

        //2. strworztc obiekt user
        Library library= new Library(data_rejestracji, data_usuniecia,  autor, ISBN,  tytul) ; // dlatego robimy konstruktor.deklaruje zmienna typu user o nazwie user

        // o nazwnie mojpies i tworzy nowy obiekt klasy Pies uzywajac przy tym zmiennych
        //nr 3 ponizej zapisac usera w bazie danych
        try { // try catch wywala wyjatek  , wtedy trzeba try/catch
            libraryDao.save(library); // przekazujemy uzytkownika ktorego tu zrobilismy do metody zapisu
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/librariesListServletMapping");// akcja do ktorej przekierowac uzytkownika
    }
}
