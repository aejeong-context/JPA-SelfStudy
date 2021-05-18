package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {
  @Id
  @GeneratedValue
  @Column(name = "CETEGORY_ID")
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private List<Category> child = new ArrayList<>();

  @ManyToMany
  @JoinTable(
      name = "CATEGOEY_ITEM",
      joinColumns = @JoinColumn(name = "CATEGORY_ID"),
      inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
  private List<Item> itemList = new ArrayList<>();
}
