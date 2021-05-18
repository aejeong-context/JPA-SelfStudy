package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  private String name;
  private String city;
  private String street;
  private String zipcods;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  //  @OneToMany(mappedBy = "order")
//  private List<Order> orderList = new ArrayList<>();


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZipcods() {
    return zipcods;
  }

  public void setZipcods(String zipcods) {
    this.zipcods = zipcods;
  }
}
