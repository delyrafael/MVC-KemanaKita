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
public class DAORating implements ImplementRating {

    Connection connection;
    final String insert = "INSERT INTO rating(id_cafe,rate )VALUES(?,?)";
    final String delete = "DELETE FROM rating WHERE id_rate=?";   
    final String update = "UPDATE rating Set id_cafe=?,rate=? WHERE id_rate=?";
    final String select = "SELECT *FROM rating";
    final String carinama = "SELECT *FROM rating WHERE id_rate like ?";
    final String average = "SELECT AVG(rate) AS rata_rata_rate FROM rating WHERE id_cafe = ?";
    final String gruprate = "SELECT c.nama_cafe, AVG(r.rate) as rata_rata_rating FROM table_cafe c JOIN rating r ON c.id_cafe = r.id_cafe GROUP BY c.nama_cafe";
    
    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini
    public DAORating() {
       // this.connection = connection;
        connection=koneksi_db.connection();
    }

    @Override
    public void insert(Mod_Rating mb) {
        PreparedStatement statement = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement = connection.prepareStatement(insert);
            statement.setInt(1, mb.getId_cafe());
            statement.setDouble(2, mb.getRate());
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
    public void update(Mod_Rating mb) {
        //final String update = "UPDATE table barang Set nama=?,harga=?,stok=? WHERE no=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);//update datanya dari form
            statement.setInt(1, mb.getId_cafe());
            statement.setDouble(2, mb.getRate());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Mod_Rating> getAll() {
        //memasukkan data ke dalam array list
        List<Mod_Rating>lmb=null;
        
       
        try {
             lmb=new ArrayList<Mod_Rating>();
             Statement st = connection.createStatement();
             ResultSet rs=st.executeQuery(select);
             while(rs.next()){
                 /*
                 mengambil data dari table di database
                 */
                 //=======================================================
                 //mod_barang dalah tempat penyimpanan data sementara
                 //simpan data ke model
                 Mod_Rating mb=new Mod_Rating();
                 mb.setId_rate(rs.getInt("id_rate"));
                 mb.setId_cafe(rs.getInt("id_cafe"));
                 mb.setRate(rs.getDouble("rate"));
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
    public List<Mod_Rating> getCarinama(int id_cafe) {
        List<Mod_Rating>lmb=null;
        try {
            lmb=new ArrayList<Mod_Rating>();
            PreparedStatement st=connection.prepareStatement(carinama);
            st.setString(1,"%"+ id_cafe+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {    
                 Mod_Rating mb=new Mod_Rating();
                 mb.setId_rate(rs.getInt("id_rate"));
                 mb.setId_cafe(rs.getInt("id_cafe"));
                 mb.setRate(rs.getDouble("rate"));
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
    public void average(int id_cafe) {
        PreparedStatement statement = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement = connection.prepareStatement(average);
            statement.executeUpdate();
            ResultSet hasil = statement.executeQuery(average);
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




}
