package jpa.basic;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import org.hibernate.Hibernate;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {

            Member member1 = new Member();
            member1.setUsername("member1");
            entityManager.persist(member1);

            entityManager.flush();
            entityManager.clear();

            Member m1 = entityManager.find(Member.class, member1.getId());

            Member refMember = entityManager.getReference(Member.class, member1.getId());

            refMember.getUsername();

            Hibernate.initialize(refMember); // refMember 강제초기화

            System.out.println("isLoaded : " + entityManagerFactory.getPersistenceUnitUtil().isLoaded(refMember));

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close(); // 엔티티 매니저를 닫아주는것이 중요함.
        }

        entityManagerFactory.close();
    }

}