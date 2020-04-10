package com.hibernate.mapping.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// This is many to many relationship between Employee and Address Object

@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EMP_ID")
  private long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "designation")
  private String designation;

  @Column(name = "salary")
  private double salary;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "Employee_Address",
      joinColumns = {@JoinColumn(name = "EMP_ID")},
      inverseJoinColumns = {@JoinColumn(name = "ADDR_ID")})
  private List<Address> addressList = new ArrayList<>();

  public Employee() {}

  public Employee(String name, String designation, double salary, List<Address> addressList) {
    this.name = name;
    this.designation = designation;
    this.salary = salary;
    this.addressList = addressList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public List<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", designation='"
        + designation
        + '\''
        + ", salary="
        + salary
        + ", addressList="
        + addressList
        + '}';
  }
}
