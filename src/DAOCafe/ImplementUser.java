/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOCafe;

import Model.Mod_user;
import java.util.List;

/**
 *
 * @author S510
 */
public interface ImplementUser {

    public void insert(Mod_user mb);
    public void finfid(Mod_user mb);
    public void findnama(Mod_user mb);
    public void delete(int id_user);
    public void update(Mod_user mb);

    public List<Mod_user> getAll();//dapatkan semua data

    public List<Mod_user> getCarinama(String nama);//mendapatkan data nama
    

}
