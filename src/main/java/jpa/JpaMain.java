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

      // 저장
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

      Member member = new Member();
      member.setUsername("member1");
      // 외래키 식별자를 직접 다룬다.
      //      member.setTeamId(team.getId());
      //      em.persist(member);

      // 연관관계 사용
      member.setTeam(team);
      em.persist(member);


      // 연관관계 사용
      //      Member findMember = em.find(Member.class, member.getId());
      //      Long findTeamId = findMember.getTeamId();
      //      Team findTeam = em.find(Team.class,findTeamId);

      Member findMember = em.find(Member.class, member.getId());

      Team findTeam = findMember.getTeam();
      System.out.println(findTeam.getName());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
