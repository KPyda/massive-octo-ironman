package com.testspring.app;

import java.util.List;
import java.util.Iterator;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Created by Praktykant on 03.09.14.
 */
public class App {
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {

        try {
            // get configuration from hibernate.cfg.xml file and use it to create sessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }

        // makes new App object (but 'this' can be used as well)
        App app = new App();

        // adds few employees into database
        Integer empID_1 = app.addEmployee("Zara", "Ali", 1000);
        Integer empID_2 = app.addEmployee("Daisy", "Das", 5000);
        Integer empID_3 = app.addEmployee("John", "Paul", 10000);

        // lists down employees
        app.listEmployees();

        // updates employee's records
        app.updateEmployeeSalary(empID_1, 5000);

        // deletes an employee from database
        app.deleteEmployee(empID_2);

        // list down new list of employees
        app.listEmployees();
    }

    // Method to CREATE and employee in the database
    public Integer addEmployee(String fname, String lname, int salary) {
        // get session object using sessionFactory
        Session session = sessionFactory.openSession();

        // transaction is a unit of work in database
        Transaction tx = null;

        Integer employeeId = null;
        try {
            // begin recording transaction
            tx = session.beginTransaction();

            Employee employee = new Employee(fname, lname, salary);

            // persists transient instance and generates id for it
            employeeId = (Integer) session.save(employee);

            // ends recording transaction
            tx.commit();
        } catch (HibernateException e) {

            //  if transaction is not finalised (was not flushed properly) roll it back
            if (tx != null) tx.rollback();

            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }

    // Method to READ all the employees
    public void listEmployees( ){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            // creates new query from session object
            Query query = session.createQuery("FROM Employee");

            // returns query result as list
            List employees = query.list();

            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    // Method to UPDATE salary for an employee
    public void updateEmployeeSalary(Integer EmployeeID, int salary ){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            // session.get() returns persistent instance of given class with given identifier
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);

            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    // Method to DELETE an employee from the records
    public void deleteEmployee(Integer EmployeeID){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}


