/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dely
 */
public abstract class Rekomendasi {
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/debkemanakita";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public abstract void handleDatabase() throws SQLException;
}


