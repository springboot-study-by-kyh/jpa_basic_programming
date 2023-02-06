package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // EntityManagerFactory: 로딩시점에 하나만 만들어놔야함.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Member findMember = em.find(Member.class, 1L);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 항상 작업이 끝나면 "EntityManager" 는 닫아줘야한다.
        }
        emf.close();
    }

}
