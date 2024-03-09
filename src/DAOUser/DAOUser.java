/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOUser;
//meletakkan query2

import Koneksi.koneksi_db;
import Model.Mod_barang;
import Model.Mod_user;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
/*
Prepared statements adalah sebuah fitur yang disediakan MySQL
(dan juga beberapa aplikasi database lainnya), 
dimana kita bisa mengirim query (perintah) 
secara terpisah antara query inti dengan “data” dari query. 
Tujuannya, 
agar query menjadi lebih aman dan cepat 
(jika perintah yang sama akan digunakan beberapa kali).

 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author S510
 */
public class DAOUser implements ImplementUser {

    Connection connection;
    final String insert = "INSERT INTO user(id_user,nama_user,email_user,password_user)VALUES(?,?,?,?)";
    final String delete = "DELETE FROM user WHERE id_user=?";
    final String update = "UPDATE user Set id_user=?,nama_user=?,email_user=?,password_user=? WHERE id_user=?";
    final String select = "SELECT *FROM user";
    final String carinama = "SELECT *FROM user WHERE nama_user like ?";
    final String SignUp = "INSERT INTO user(nama_user, email_user, password_user)VALUES(?, ? , ?)";
    final String cariiduser = "SELECT * FROM user WHERE email =? AND password =?";
    final String shownama = "SELECT id_user, nama_user FROM user WHERE email_user =?";
    
    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini


    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini
    public DAOUser() {
       // this.connection = connection;
        connection=koneksi_db.connection();
    }

    @Override
    public void insert(Mod_user mb) {
        PreparedStatement statement1 = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement1 = connection.prepareStatement(insert);
            statement1.setString(1, mb.getNama_user());
            statement1.setString(2, mb.getEmail_user());
            statement1.setString(3, mb.getPassword_user());
            statement1.executeUpdate();
            //ResultSet rs = statement.executeUpdate();
            //while (rs.next()) {
               // mb.setNo(rs.getInt(1));
           // }
        } catch (SQLException ex) {
           ex.printStackTrace();
           // System.out.println("test"+ex);
        } finally {
            try {
                statement1.close();

            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
    }

    @Override
    public void delete(int id_user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id_user);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();

            }

        }    
    }

    @Override
    public void update(Mod_user mb) {
       //final String update = "UPDATE table barang Set nama=?,harga=?,stok=? WHERE no=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);//update datanya dari form
            statement.setString(1, mb.getNama_user());
            statement.setString(2, mb.getEmail_user());
            statement.setString(3, mb.getPassword_user());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Mod_user> getAll() {
        //memasukkan data ke dalam array list
        List<Mod_user>lmb=null;
        
       
        try {
             lmb=new ArrayList<Mod_user>();
             Statement st = connection.createStatement();
             ResultSet rs=st.executeQuery(select);
             while(rs.next()){
                 /*
                 mengambil data dari table di database
                 */
                 //=======================================================
                 //mod_barang dalah tempat penyimpanan data sementara
                 //simpan data ke model
                 Mod_user mb=new Mod_user();
                 mb.setId_user(rs.getInt("id_user"));
                 mb.setNama_user(rs.getString("nama_user"));
                 mb.setEmail_user(rs.getString("email_user"));
                 mb.setPassword_user(rs.getString("password_user"));
                 //setelah di getall data tersebut harus
                //ditampilkan ke dlm list
                 lmb.add(mb);
                 
             
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;
    }

    @Override
    public List<Mod_user> getCarinama(String nama) {
        List<Mod_user>lmb=null;
        try {
            lmb=new ArrayList<Mod_user>();
            PreparedStatement st=connection.prepareStatement(carinama);
            st.setString(1,"%"+ nama+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {    
                Mod_user mb=new Mod_user();
                mb.setId_user(rs.getInt("id_user"));
                mb.setNama_user(rs.getString("nama_user"));
                mb.setEmail_user(rs.getString("email_user"));
                mb.setPassword_user(rs.getString("password_user"));
                //setelah dicari data tersebut harus
                //ditampilkan ke dlm list
                lmb.add(mb);
                
            }  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lmb;
    }    
}

