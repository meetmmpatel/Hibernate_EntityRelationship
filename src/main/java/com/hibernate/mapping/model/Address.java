package com.hibernate.mapping.model;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ADDR_ID")
  private long id;

  @Column private String city;

  @Column private String state;

  @Column private String country;

  @Column private String zip;

  public Address() {}

  public Address(String city, String state, String country, String zip) {
    this.city = city;
    this.state = state;
    this.country = country;
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override
  public String toString() {
    return "Address{"
        + "id="
        + id
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + ", country='"
        + country
        + '\''
        + ", zip='"
        + zip
        + '\''
        + '}';
  }
}
