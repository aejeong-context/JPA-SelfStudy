package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    try {
      Member member1 = new Member();
      member1.setName("aejeong");
      em.persist(member1);

      Member member2 = new Member();
      member2.setName("jisu");
      em.persist(member2);

      em.flush();
      em.clear();

      Member m1 = em.find(Member.class, member1.getId());
      Member m2 = em.find(Member.class, member2.getId());

      Member reference1 = em.getReference(Member.class, member1.getId());
      Member reference2 = em.getReference(Member.class, member2.getId());
      System.out.println("m2 == m2 : "+(m1.getClass() == m2.getClass()));
      System.out.println("m2 == m2 : "+(reference1.getClass() == m1.getClass()));
      System.out.println("reference1 == reference2 : " +(m1.getClass() == reference2.getClass()));
      System.out.println("reference1 == reference2 : " +(m1 instanceof Member));
      System.out.println("reference1 == reference2 : " +(m2 instanceof Member));

      //      printMemberAndTeam(member1);
      //      printMember(member);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }

  //  private static void printMember(Member member) {
  //    System.out.println("member = " + member.getName());
  //  }
  //
  //  private static void printMemberAndTeam(Member member) {
  //    String userName = member.getName();
  //    System.out.println(userName);
  //
  //    Team team = member.getTeam();
  //    System.out.println("team = " + team.getName());
  //  }
}
