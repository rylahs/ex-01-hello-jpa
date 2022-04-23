package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // DB Start
        tx.begin();
        try {
            Team teamA = new Team();
            teamA.setName("SSG");
            em.persist(teamA);
            Team teamB = new Team();
            teamB.setName("KT");
            em.persist(teamB);

            Member memberA = new Member();
            memberA.setUsername("Rylah");
            memberA.setTeam(teamA);

            em.persist(memberA);

            Member memberB = new Member();
            memberB.setUsername("halyR");
            memberB.setTeam(teamB);

            em.persist(memberB);

            em.flush();
            em.clear();

            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();

            // SQL : SELECT * FROM MEMBER;

//
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(Member findMember1, Member findRefMember2) {
        System.out.println("findMember1 instanceof Member : " + (findMember1 instanceof Member));
        System.out.println("findRefMember2 instanceof Member : " + (findRefMember2 instanceof Member));
        System.out.println("findMember1 == findRefMember2 : " + (findMember1.getClass() == findRefMember2.getClass()));
    }


}
