package com.piotr.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * Created by jalos on 16.03.2016.
 */
public class Database {
    private Connection conn;
    private static final String URL="jdbc:mysql://localhost:3306/shopweb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void connect() throws SQLException {

        conn= DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public Connection getConn() throws SQLException {
        if (conn==null){
            connect();
        }
        return conn;
    }}

