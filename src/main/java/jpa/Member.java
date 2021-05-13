package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// Jpa가 관리하는 개체인 것을 알려준다.
@Entity
public class Member {

  @Id private Long id;
  private String name;

  // 기본 생성자가 있어야 한다.
  public Member() {
  }

  public Member(Long id, String name) {
    this.id = id;
    this.name = name;
  }

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
