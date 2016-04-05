package com.piotr.controller;

import com.piotr.dao.LibraryDao;

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

@WebServlet


public class DeleteLibraryServlet extends HttpServlet{
    private LibraryDao libraryDao=new LibraryDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numer= Integer.parseInt(req.getParameter("id")); //todo nie wiem czy ok numer
        try {
            libraryDao.deleteById(numer); //todo nie wiem czy dobrze !!!
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //<!-- zeby miec strin na int najlepiej sparsowac-->
        resp.sendRedirect("/libraryListServletMapping");
    }
}
