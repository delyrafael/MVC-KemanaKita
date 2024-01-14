/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOCafe;
//meletakkan query2

import Koneksi.koneksi_db;
import Model.Mod_Rating;
import Model.Mod_barang;
import Model.Mod_cafe;
import View.Login;
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
import javax.swing.JOptionPane;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author S510
 */
public class DAOCafe implements ImplementCafe {

    Connection connection;
    final String insert = "INSERT INTO table_cafe(id_cafe,nama_cafe,alamat_cafe,fasilitas_cafe, Deskripsi)VALUES(?,?,?,?,?)";
    final String delete = "DELETE FROM table_cafe WHERE id_cafe=?";
    final String update = "UPDATE table_cafe Set id_cafe=?,nama_cafe=?,alamat_cafe=?,fasilitas_cafe=?,Deskripsi=? WHERE id_cafe=?";
    final String select = "SELECT *FROM table_cafe";
    final String carinama = "SELECT *FROM table_cafe WHERE nama_cafe like ?";
    final String query = "SELECT c.nama_cafe, AVG(r.rate) as rata_rata_rating FROM table_cafe c JOIN rating r ON c.id_cafe = r.id_cafe WHERE c.nama_cafe =? GROUP BY c.nama_cafe;";
    final String shownama = "SELECT id_user, nama_user FROM user WHERE email_user =?";
    
    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini
    public DAOCafe() {
       // this.connection = connection;
        connection=koneksi_db.connection();
    }

    @Override
    public void insert(Mod_cafe mb) {
        PreparedStatement statement = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement = connection.prepareStatement(insert);
            statement.setString(1, mb.getNama_cafe());
            statement.setString(2, mb.getAlamat_cafe());
            statement.setString(3, mb.getFasilitas_cafe());
            statement.setString(3, mb.getDeskripsi());
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
    public void delete(int id_cafe) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id_cafe);
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
    public void update(Mod_cafe mb) {
        //final String update = "UPDATE table barang Set nama=?,harga=?,stok=? WHERE no=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);//update datanya dari form
            statement.setString(1, mb.getNama_cafe());
            statement.setString(2, mb.getAlamat_cafe());
            statement.setString(3, mb.getFasilitas_cafe());
            statement.setString(4, mb.getDeskripsi());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Mod_cafe> getAll() {
        //memasukkan data ke dalam array list
        List<Mod_cafe>lmb=null;
        
       
        try {
             lmb=new ArrayList<Mod_cafe>();
             Statement st = connection.createStatement();
             ResultSet rs=st.executeQuery(select);
             while(rs.next()){
                 /*
                 mengambil data dari table di database
                 */
                 //=======================================================
                 //mod_barang dalah tempat penyimpanan data sementara
                 //simpan data ke model
                 Mod_cafe mb=new Mod_cafe();
                 mb.setId_cafe(rs.getInt("id_cafe"));
                 mb.setNama_cafe(rs.getString("nama_cafe"));
                 mb.setAlamat_cafe(rs.getString("alamat_cafe"));
                 mb.setFasilitas_cafe(rs.getString("fasilitas_cafe"));
                 mb.setDeskripsi(rs.getString("Deskripsi"));
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
    public List<Mod_cafe> getCarinama(String nama) {
        List<Mod_cafe>lmb=null;
        try {
            lmb=new ArrayList<Mod_cafe>();
            PreparedStatement st=connection.prepareStatement(carinama);
            st.setString(1,"%"+ nama+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {    
                Mod_cafe mb=new Mod_cafe();
                mb.setId_cafe(rs.getInt("id_cafe"));
                mb.setNama_cafe(rs.getString("nama_cafe"));
                mb.setAlamat_cafe(rs.getString("alamat_cafe"));
                mb.setFasilitas_cafe(rs.getString("fasilitas_cafe"));
                mb.setDeskripsi(rs.getString("Deskripsi"));
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
    public void getrate(Mod_Rating mr) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);            
            statement.setInt(1, mr.getId_rate());
            statement.setInt(2, mr.getId_cafe());
            statement.setDouble(3, mr.getRate());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
  
    }

    @Override
    public List<Mod_cafe> getCafeRandom() {
        List<Mod_cafe> lmb = null;
        try {
            lmb = new ArrayList<>();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM table_cafe ORDER BY RAND() LIMIT 5"); // Query untuk mengambil 5 cafe secara random
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Mod_cafe mb = new Mod_cafe();
                mb.setId_cafe(rs.getInt("id_cafe"));
                mb.setNama_cafe(rs.getString("nama_cafe"));
                mb.setAlamat_cafe(rs.getString("alamat_cafe"));
                mb.setFasilitas_cafe(rs.getString("fasilitas_cafe"));
                mb.setDeskripsi(rs.getString("Deskripsi"));
                lmb.add(mb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;    
    }

    @Override
    public void findnama(Mod_cafe mb) {
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
                mb.setNama_cafe(namaUser);
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
        }    }
}
