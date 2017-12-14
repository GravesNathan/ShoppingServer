/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import main.HibernateUtil;
import java.util.Random;
import model.Members;
import main.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author NathanG
 */
//@ManagedBEan
//@SessionScoped
public class MemberControl {
    
//    static SessionFactory sessionFactory = null;
//    static{
//        Configuration config=new Configuration();
//        config.configure();
//        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
//        builder.applySettings(config.getProperties());
//        MetadataSources metadataSources=new MetadataSources();
//        metadataSources.addAnnotatedClass(Members.class);
//        Metadata metadata = metadataSources.buildMetadata(builder.build());
//        sessionFactory=metadata.buildSessionFactory();
//    }
    
    private Members member;
    private String tempName;
    private HibernateUtil helper;
    private Session session;
    private String username;
    private String password;
    private double wallet;
    private String cart;

    public MemberControl() {//General Constructor
    }
    
//    public MemberControl(String username, String password, double wallet, String cart){//Add new member constructor, may not use...we'll see
//        //I am concerned about if this consturctor is ever called when we aren't trying to add a member so let's separate it out.
//        member = new Members(username);
//        session = helper.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.save(member);
//        session.getTransaction().commit();
//        session.close();
//    }
    
    public void addMember(String username, String password){//Add new member, call from controller.
        member = new Members(username, password);
        System.out.println("Just added to model.");
    try{
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(member);
        session.getTransaction().commit();
        session.flush();
        session.close();
    } catch (HibernateException ex){
    }
    }
    
//    public String getMember(){
    public String getMember(int member_id) {
    try{
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        member = (Members) session.get(Members.class, member_id);
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.wallet = member.getWallet();
        this.cart = member.getCart();
        session.flush();
        session.close();
    } catch (HibernateException ex){
        String toReturn = "We ran into a query error.  Please ensure the correct member_id was entered";
        return toReturn;
    }
        String toReturn = "username: " + username +" wallet: "+ wallet +" cart: "+ cart;
        return toReturn;
    }
    
    private String createName() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    
    
}