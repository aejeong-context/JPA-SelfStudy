package jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

  @Id private Long id;
  private String name;
  private Integer age;
  @Enumerated(EnumType.STRING)
  private RoleType roleType;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified;
  @Lob
  private String description;

  // 기본 생성자가 있어야 한다.
  public Member() {
  }

  public Member(Long id, String name, Integer age, RoleType roleType, Date createDate, Date modified, String description) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.roleType = roleType;
    this.createDate = createDate;
    this.modified = modified;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public RoleType getRoleType() {
    return roleType;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public Date getModified() {
    return modified;
  }

  public String getDescription() {
    return description;
  }
}
