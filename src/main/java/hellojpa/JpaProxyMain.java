package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaProxyMain {


	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		//code
		try {
			Member member1 = new Member();
			member1.setUsername("member1");
			em.persist(member1);

			Member member2 = new Member();
			member1.setUsername("member2");
			em.persist(member2);

			em.flush();
			em.clear();

			Member m1 = em.find(Member.class, member1.getId());
			Member m2 = em.find(Member.class, member2.getId());
			Member m3 = em.find(Member.class, member1.getId());
			Member m4 = em.getReference(Member.class, member2.getId());//겟레퍼런스는 엔티티의 프록시 객체를 반환한다.
			//프록시 객체를 사용하는 경우는 아래와 같다
			//1.엔티티를 조회할 필요가 없는 경우
			// 연관 엔티티를 로딩하지 않고, 엔티티의 프록시 객체만 생성할 수 있습니다.
			// 이 경우, 실제 엔티티 객체가 필요한 경우에만 연관 엔티티를 로딩할 수 있습니다.
			// 이는 성능이 향상되고, 메모리 사용량을 줄일 수 있습니다.

			//2.연관 엔티티를 로딩하지 않고, 프록시 객체를 생성하는 경우
			//연관 엔티티를 로딩하지 않고, 엔티티의 프록시 객체만 생성할 수 있습니다.
			// 이 경우, 실제 엔티티 객체가 필요한 경우에만 연관 엔티티를 로딩할 수 있습니다.
			// 이는 성능이 향상되고, 메모리 사용량을 줄일 수 있습니다.

			//3.엔티티의 존재 여부를 확인하는 경우
			//엔티티를 조회하지 않고, 엔티티 식별자(ID)만 사용하여 엔티티의 존재 여부를 확인할 수 있습니다.
			// 이는 엔티티를 실제로 로딩하지 않고, 존재 여부만 확인할 수 있으므로 성능이 향상됩니다.

			//4.엔티티의 일부 속성만 사용하는 경우
			// 엔티티를 프록시 객체로 가져온 후, 필요한 속성만 사용할 수 있습니다.
			// 이 경우, 모든 속성을 로딩하지 않고, 필요한 속성만 로딩하여 성능을 향상시킬 수 있습니다.

			//결론 엔티티를 조회해서 성능향상

			/* 챗GPT의 답변
			* 	find()와 getReference()는 모두 엔티티를 조회하는 메소드입니다.
				find() 메소드를 사용하면 엔티티를 실제로 조회하고, 모든 속성을 로딩합니다.
				따라서 엔티티의 모든 속성을 사용해야 하는 경우에 적합합니다.
				반면에 getReference() 메소드를 사용하면 엔티티의 프록시 객체를 반환합니다.
				프록시 객체는 실제 엔티티 객체와 동일한 인터페이스를 가지고 있지만, 실제 엔티티 객체가 필요할 때까지는 데이터베이스에서 조회하지 않습니다.
				따라서, getReference()를 사용하여 필요한 속성만 로딩하거나,
				엔티티의 존재 여부를 확인하거나,
				연관 엔티티를 로딩하지 않고 엔티티의 프록시 객체만 생성하는 등의 경우에 적합합니다.
				즉, find()는 모든 속성을 로딩하여 엔티티 객체를 반환하는 반면,
				getReference()는 엔티티의 프록시 객체를 반환하며 필요한 시점에 로딩합니다.
				따라서 두 메소드를 사용할 때, 로딩할 속성에 대한 차이가 있으며, 상황에 맞게 사용해야 합니다.
			*/
			//영속성 컨텍스트에 해당 엔티티가 있을때 조회해오지, 없으면 find()랑 다를게 없음.

			System.out.println("m1 == m2 " + (m1.getClass() == m2.getClass()));//true
			System.out.println("m3 == m4 " + (m3.getClass() == m4.getClass()));//false m4는 프록시라서, 다름

			//true m4는 Proxy기 때문에 getClass()를 비교하면 다름, instanceof를 사용해 비교하면 같음.
			System.out.println("m3 == m4 " + (m3 instanceof Member));
			System.out.println("m3 == m4 " + (m4 instanceof Member));

			//m2와 m4의 class가 같다고 나옴.
			// 이유는? jpa에서는 객체든 프록시든 하나의 영속성 컨테이너에서 가져오기 때문에 같다고 봄
			// 같은 객체를 참조한다고 이해하면 되겠음
			// 만약 m1을 겟레퍼런스로 초기화 했다면, m2와 m4도 프록시 객체 반환
			System.out.println("m2 = " + m2); //m2= class hellojpa.Member 반환
			System.out.println("m4 = " + m4); //m4= class hellojpa.Member 반환

			//proxy조회한 객체 이후 같은 entity를 find했을때
			//proxyclass를 반환함

			tx.commit();
		} catch (Exception e){
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
