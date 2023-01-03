package jpa.basic;

import java.util.List;
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

        try {
            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add(member);
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            Team findTeam = entityManager.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("=============");

            for(Member member1 : members){
                System.out.println("member : " + member1.getUsername());
            }

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close(); // 엔티티 매니저를 닫아주는것이 중요함.
        }

        entityManagerFactory.close();
    }
}