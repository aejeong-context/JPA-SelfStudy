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
      Member member = new Member();
      member.setName("aejeong");
      em.persist(member);

      em.flush();
      em.clear();

      // 호출한 순간 쿼리 실행
      Member findMember = em.find(Member.class, member.getId());
      // 호출했을 때 실행 안함
      Member findMember2 = em.getReference(Member.class, member.getId());
      // 이때 쿼리 실행 함
      System.out.println("findMember = " + findMember.getName());


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
