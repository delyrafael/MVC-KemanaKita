/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class koneksi_db {
    //langkah setelah database connection
    static Connection con;
    public static Connection connection(){
        if(con==null){
            MysqlDataSource data =new MysqlDataSource();
            data.setPort(3306);
            data.setDatabaseName("dbkemanakita");
            data.setUser("root");
            data.setPassword("");
            
            try {
                con=data.getConnection();
            } catch (SQLException ex) {
                //Logger.getLogger(koneksi_db.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }      
        }
        return con;
    
    }
    
}
