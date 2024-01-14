/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Dely
 */
public class Mod_review {
//    private int id_review;
//    private int id_cafe;
//    private int id_user;
//    private String review;
//
//    public int getId_review() {
//        return id_review;
//    }
//
//    public void setId_review(int id_review) {
//        this.id_review = id_review;
//    }
//    
//    public int getId_cafe() {
//        return id_cafe;
//    }
//
//    public void setId_cafe(int id_cafe) {
//        this.id_cafe = id_cafe;
//    }
//
//    public int getId_user() {
//        return id_user;
//    }
//
//    public void setId_user(int id_user) {
//        this.id_user = id_user;
//    }
//
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
    
    private String namacafe;
    private String emailUser;
    private  String review;
    private String nama_user;

    public String getNamacafe() {
        return namacafe;
    }

    public void setNamacafe(String namacafe) {
        this.namacafe = namacafe;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
        
    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }   
    
}
