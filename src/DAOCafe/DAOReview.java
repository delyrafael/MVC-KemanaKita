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
import Model.Mod_review;
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
public class DAOReview implements ImplementReview {

    Connection connection;
    final String insert = "INSERT INTO rating(id_cafe,id_user,review)VALUES(?,?,?)";
    final String delete = "DELETE FROM rating WHERE id_cafe=?";
    final String update = "UPDATE rating Set id_review=?,id_cafe=?,id_user=?,review=? WHERE id_review=?";
    final String select = "SELECT *FROM rating WHERE id_review=?";
    final String carinama = "SELECT *FROM rating WHERE id_cafe like ?";
    final String ShowReview = "SELECT user.nama_user, review.review FROM review INNER JOIN table_cafe ON review.id_cafe = table_cafe.id_cafe INNER JOIN user ON review.id_user = user.id_user WHERE table_cafe.nama_cafe=?";
    final String insertReview = "INSERT INTO review (id_review, id_cafe, id_user, review) VALUES (NULL, (SELECT id_cafe FROM table_cafe WHERE nama_cafe = ?), (SELECT id_user FROM user WHERE email_user = ?), ?)";
    
    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini
    public DAOReview() {
       // this.connection = connection;
        connection=koneksi_db.connection();
    }

    @Override
    public void insert(Mod_review mb) {
        try {
            PreparedStatement ps = connection.prepareStatement(insertReview);
            ps.setString(1, mb.getNamacafe());
            ps.setString(2, mb.getEmailUser());
            ps.setString(3, mb.getReview());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public void update(Mod_review mb) {
        //final String update = "UPDATE table barang Set nama=?,harga=?,stok=? WHERE no=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);//update datanya dari form
            statement.setString(1, mb.getNamacafe());
            statement.setString(2, mb.getEmailUser());
            statement.setString(3, mb.getReview());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public List<Mod_review> getCarinama(String nama) {
        List<Mod_review>lmb=null;
        try {
            lmb=new ArrayList<Mod_review>();
            PreparedStatement st=connection.prepareStatement(carinama);
            st.setString(1,"%"+ nama+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {    
                 Mod_review mb=new Mod_review();
                 mb.setNamacafe(rs.getString("nama_cafe"));                 
                 mb.setEmailUser(rs.getString("email_user"));
                 mb.setReview(rs.getString("review"));
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
    public List<Mod_review> getAll(String nama) {
        List<Mod_review> lmb = null;

        try {
            lmb = new ArrayList<Mod_review>();
            PreparedStatement st = connection.prepareStatement(ShowReview);
            st.setString(1, nama);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                /*
                mengambil data dari table di database
                */
                //=======================================================
                //mod_barang dalah tempat penyimpanan data sementara
                //simpan data ke model
                Mod_review mb = new Mod_review();
                mb.setNamacafe(rs.getString("nama_user"));
                mb.setReview(rs.getString("review"));

                //setelah di getall data tersebut harus
                //ditampilkan ke dlm list
                lmb.add(mb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lmb;
    }
}
