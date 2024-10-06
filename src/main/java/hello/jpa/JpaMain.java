package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // 어플리케이션 로딩  시점에 하나만 만들기
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 비영속 상태
            Member member = new Member();
            member.setId(3L);
            member.setName("HELLO JPA");

            // 영속 상태
            em.persist(member);

            System.out.println("before");
            tx.commit();
            System.out.println("after");

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
        /* JPA 데이터 저장
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            em.persist(member); // member 객체 저장

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        */

        /* JPA 수정
        try {
            Member member = em.find(Member.class, 1L);
            member.setName("helloB");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        */

        /* 데이터 삭제
        try {
                Member member = em.find(Member.class, 1L);
        em.remove(member);
        tx.commit();
        } catch (Exception e) {
        tx.rollback();
        } finally {
        em.close();
        }
        */

        /* JPQL query
        try {
            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
            for (Member member : result) {
                System.out.println(member);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        */