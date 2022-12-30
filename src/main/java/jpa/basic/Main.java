package jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Member member = new Member();
        member.setId(1L);
        member.setName("HelloA");

        entityManager.persist(member);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}