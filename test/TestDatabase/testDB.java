/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDatabase;

import control.MemberControl;

/**
 *
 * @author NathanG
 */
public class testDB {
    public static void main(String[] args) {
    MemberControl member = new MemberControl();
    member.addMember("username", "password");
    System.out.println(member.getMember());
    System.out.println("Did it work?");  
    
    //Note, due to a bug in or possibly my own mistake session factory isn't closing.
    }
}
