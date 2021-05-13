package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    try {

      //      Member member = em.find(Member.class, 1L);
      // JPQL 객체를 대상으로한 쿼리이기 때문에 방언에 맞춰서 각 DB에 맞게 변역을 해준다.
      List<Member> result =
          em.createQuery("select m from Member m", Member.class)
              .setFirstResult(8)
              .setMaxResults(5)
              .getResultList();

      for (Member member : result) {
        System.out.println(member);
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
