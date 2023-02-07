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

        /**
         * 영속성 컨텍스트
         * - 엔티티를 영구 저장하는 환경이라는 의미
         * - EntityManager.persist(entity);
         * - DB가 아니라 영속성 컨텍스트에 접근
         */

        /**
         * 비영속 상태
         * - JPA와 전혀 연관이 없는 상
         *
         * 영속 상태
         * - EntityManager em = emf.createEntityManager();
         * em.persist(~) : 객체를 저장한 상태(영속)
         */

        tx.begin();
        try {

            Member member = new Member();
            member.setId(100L);
            member.setName("JPA");

            em.persist(member); // 영속상태
            em.detach(member); // 영속성 컨텍스트에서 지우는것.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 항상 작업이 끝나면 "EntityManager" 는 닫아줘야한다.
        }
        emf.close();
    }

}
