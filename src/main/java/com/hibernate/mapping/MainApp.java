package com.hibernate.mapping;

import com.hibernate.mapping.model.Address;
import com.hibernate.mapping.model.Employee;
import com.hibernate.mapping.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

  public static final Logger LOGGER = LogManager.getLogger(MainApp.class);

  public static void main(String[] args) {
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();

      Address addressOne = new Address("Falls church", "Fairfax", "VA", "22046");
      Address addressTwo = new Address("Maclean", "Fairfax", "VA", "22048");

      // Employee One will have address one
      Employee employeeOne = new Employee();
      employeeOne.setName("Jeck");
      employeeOne.setSalary(45000);
      employeeOne.setDesignation("Sr, Developer");
      employeeOne.getAddressList().add(addressOne);

      // Employee Two will have address one and two (both)
      Employee employeeTwo = new Employee();
      employeeTwo.setName("Mark");
      employeeTwo.setSalary(55000);
      employeeTwo.setDesignation("Sr, Manager");
      employeeTwo.getAddressList().add(addressOne);
      employeeTwo.getAddressList().add(addressTwo);

      session.save(employeeOne);

      session.save(employeeTwo);

      LOGGER.info("Object hab been added in database");
      transaction.commit();

      LOGGER.info("Address has been added into Database");

    } catch (Exception e) {
      if (transaction != null) {
        LOGGER.error("Transaction is being rolled back");
        e.printStackTrace();
        transaction.rollback();
      }
    } finally {
      LOGGER.info("Shutdown the hibernate connection");
      HibernateUtil.shutdown();
    }
  }
}
