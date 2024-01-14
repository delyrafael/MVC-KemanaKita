/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOCafe;
//meletakkan query2

import Koneksi.koneksi_db;
import Model.Mod_barang;
import Model.Mod_cafe;
import Model.Mod_user;
import View.Login;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JOptionPane;
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
    final String cariiduser = "SELECT * FROM user WHERE email =? AND password =?";
    final String shownama = "SELECT id_user, nama_user FROM user WHERE email_user =?";
    
    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini
    public DAOUser() {
       // this.connection = connection;
        connection=koneksi_db.connection();
    }

    @Override
    public void insert(Mod_user mb) {
        PreparedStatement statement = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement = connection.prepareStatement(insert);
            statement.setString(1, mb.getNama_user());
            statement.setString(2, mb.getEmail_user());
            statement.setString(3, mb.getPassword_user());
            statement.executeUpdate();
            //ResultSet rs = statement.executeUpdate();
            //while (rs.next()) {
               // mb.setNo(rs.getInt(1));
           // }
        } catch (SQLException ex) {
           ex.printStackTrace();
           // System.out.println("test"+ex);
        } finally {
            try {
                statement.close();

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

    @Override
    public void finfid(Mod_user mb) {
        PreparedStatement statement = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement = connection.prepareStatement(shownama);
            statement.setString(1, mb.getEmail_user());
            statement.executeUpdate();
            //ResultSet rs = statement.executeUpdate();
            //while (rs.next()) {
               // mb.setNo(rs.getInt(1));
           // }
        } catch (SQLException ex) {
           ex.printStackTrace();
           // System.out.println("test"+ex);
        } finally {
            try {
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
    }

    @Override
    public void findnama(Mod_user mb) {
        PreparedStatement statement = null;
        String email = Login.txtEmail.getText();

        try {
            // Prepare the statement for efficiency and security
            statement = connection.prepareStatement(shownama);
            statement.setString(1, email);

            // Execute the query
            ResultSet rs = statement.executeQuery();

            // If a matching user is found
            if (rs.next()) {
                // Retrieve the nama_user from the result set
                String namaUser = rs.getString("nama_user");

                // Set the nama_user in the Mod_user object
                mb.setNama_user(namaUser);
            } else {
                // Display an appropriate error message if no match is found
                JOptionPane.showMessageDialog(null, "Email tidak terdaftar.", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            // Handle database-related errors gracefully
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada database.", "Error", JOptionPane.ERROR_MESSAGE);
            // Log or print the exception for debugging
            ex.printStackTrace();
        } finally {
            // Ensure proper resource closure
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
