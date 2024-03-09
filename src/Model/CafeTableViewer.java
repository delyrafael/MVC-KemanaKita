/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAOCafe.DAOCafe;
import DAOCafe.ImplementCafe;
import View.MainpageAnon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Dely
 */

public class CafeTableViewer extends Rekomendasi {
    ImplementCafe implCafe;
    List<Mod_cafe> lmb;
    @Override
    public void handleDatabase() throws SQLException {
    implCafe = new DAOCafe();
    List<Mod_cafe> lmb = implCafe.getCafeRandom(); // Panggil method getCafeRandom() untuk mendapatkan data cafe secara random
    Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
    MainpageAnon.getTableRec().setModel(mtb);
    try (Connection connection = getConnection()) {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM table_cafe ORDER BY RAND() LIMIT 5");

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
}

}