/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOCafe;

import Model.Mod_cafe;
import Model.Mod_Rating;
import java.util.List;

/**
 *
 * @author S510
 */
public interface ImplementCafe {

    public void insert(Mod_cafe mb);
    public void findnama(Mod_cafe mb);
    public void delete(String id_cafe);
    public void update(Mod_cafe mb);

    public List<Mod_cafe> getAll();//dapatkan semua data

    public List<Mod_cafe> getCarinama(String nama);//mendapatkan data nama
    public void getrate(Mod_Rating mr);
    public  List<Mod_cafe> getCafeRandom();
    public  List<Mod_cafe> getWishlistCafe();
    public Mod_cafe findnama(String email);

    
    

}
