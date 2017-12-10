/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//8:29

/**
 *
 * @author Nathan
 */
public class Members {

    private int member_id;
    private String username; 
    private String password;
    private double wallet;
    private String cart;//May need to change type for larger strings if there is one.
    //This will store potentially large strings of JSON for their existing cart.

   public Members(){}//General constructor

    public Members(String username, String password) {//Add new Member Constructor, may not use...we'll see
      this.username = username;
      this.password = password;
   }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
    
}