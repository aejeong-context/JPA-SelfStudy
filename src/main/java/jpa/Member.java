package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// Jpa가 관리하는 개체인 것을 알려준다.
@Entity
public class Member {

  @Id private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
