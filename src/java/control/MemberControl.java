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
    private String name;

    public MemberControl() {
        tempName = createName();
        addMember(tempName);
    }
    
    public MemberControl(String username){
        addMember(username);
    }
    
    public void addMember(String name){
        member = new Members(name);
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(member);
        session.getTransaction().commit();
        session.close();
    }
    
    public String getName(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        member = (Members) session.get(Members.class, 1);
        this.name = member.getName();
        return name;
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