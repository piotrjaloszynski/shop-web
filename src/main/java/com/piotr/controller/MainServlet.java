package com.piotr.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jalos on 15.03.2016.
 */

@WebServlet("/")// zglosi sie gdy poprosimy glowna strone aplikacji
public class MainServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // robimy zeby wywolac do get dla slasza  , do get wpisujemy ponizsze sciezka do zasobi ktory znalezc do katalogu. szukamy
        // w dokumentacji  java doc  , robisz klase httpservlet . how to return jsp index .
        RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/index.jsp");
        // dispatcher to zmienna  w metoda forward  musisz podac req  i response. i  serwr wysyla odpowiedz do przegladarki
        // z tresci przeglaradki metoda !! forward. include sie nie uzywa

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
// 1. dostepna bo sciagnelismy servlet api  httpservlet
    //2. zdefiniowanie na jaka akcje ma  servlet odpowiadac , sie zglosi @webservlet
}
