package client;

import java.util.Set;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.SessionFactoryBuilder;

public class User {

    protected int id;
    protected String password; //Corrected
    protected String role;
    protected String name;

    private SessionFactory factory;

    public User() {
        id = 000;
        password = "Default"; //Corrected
        role = "Default";
        name = "Default";
    }

    public User(int i, String password2, String r, String n) {
        this.id = i;
        this.password = password2; //Corrected
        this.role = r;
        this.name = n;
    }

    public User(SessionFactory factory) {
        this.factory = SessionFactoryBuilder.getSessionFactory();
    }

    public User(User u) {

    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    //Corrected
    public String getPassword() {
        return password;
    }

    //Corrected
    public void setPassword(String pword) {
        this.password = pword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "id: " + id + " Password: " + password + " Name: " + name + " Role: " + role;
    }

    public User read(int id) {
        try (Session session = SessionFactoryBuilder.getSessionFactory().openSession()) {
            System.out.println(id);
            return session.get(User.class, id);
        }
    }

    public void create(User User) {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            if (!transaction.isActive()) {
                transaction.begin(); // Start a new transaction if one isn't active
            }

            session.save(User);
            System.out.println(User);

            if (User instanceof Customer) {
                Customer cust = (Customer) User;
                // cust.create(cust, transaction);
                // Customer cust = new Customer();
                cust.create(cust, transaction);

                
                // System.out.println(cust);
            } else {
                // Employee emp = new Employee();
                Employee emp = (Employee) User;
                emp.create(emp, transaction);
                // System.out.println(emp);
            }

            if (transaction.isActive()) {
                transaction.commit();
            }

            JOptionPane.showMessageDialog(null, "Record Inserted Successfully", "Database Operation",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException re) {
            if (transaction.isActive()) {
                re.printStackTrace();
                JOptionPane.showMessageDialog(null, "Record Not Inserted Performing " + "Rollback",
                        "Database Operation", JOptionPane.ERROR_MESSAGE);
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}