package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class JpqlMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			//1.JSQL
			//JPQL이란 SQL을 추상화한 객체지향 SQL, 테이블이 아닌 객체를 대상으로 검색하는 객체지향 쿼리.
			//조회 예제
			List<Member> result = em.createQuery(
										"select m from Member m where m.username like '%kim%'", Member.class)
									.getResultList();
			result = em.createQuery(
						   "select m from Member m where m.age > 18", Member.class)
					   .getResultList();

			//2. Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Member> query = cb.createQuery(Member.class);

			Root<Member> m = query.from(Member.class);

			CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
			List<Member> result2 = em.createQuery(cq).getResultList();

			//

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
