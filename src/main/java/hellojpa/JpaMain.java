package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * packageName  : hellojpa
 * fileName     : JpaMain
 * author       : sshan
 * date         : 2023-02-26
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-02-26          sshan            최초생성
 */
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {
            //JPA는 SQL을 추상화한 JPQL이라는 객체지향쿼리 언어 제공
            //JPQL은 엔티티 객체를 대상으로 쿼리
            //SQL은 데이터베이스 테이블 대상으로 쿼리
            /* insert */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
//            tx.commit();
            /* select */
            //지정 회원 조회
//            Member findMember = em.find(Member.class, 1L);

            //전체 회원 조회
//            List<Member> result = em.createQuery("select m from Member as m where m.name=helloA", Member.class)
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    //페이징
//                    .setFirstResult(1)
//                    .setMaxResults(8)
//                                    .getResultList();
//            for(Member member : result){
//                System.out.println("member.name="+member.getName());
//            }

            /* delete */
//            em.remove(findMember);

            /* update */
//            findMember.setName("HelloJPA");
            //이것만 해도 업데이트 됨..

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
