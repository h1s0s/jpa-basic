package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
public class JpaMain2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {
            Address address = new Address("city", "street", "10000");

            Member3 member = new Member3();
            member.getName("member1");
            member.getHomeAddress();
            em.persist(member);

            Member3 member2 = new Member3();
            member2.getName("member2");
            member2.getHomeAddress();
            em.persist(member2);

            member.getHomeAddress().setCity("NEWCITY");//member의 city만 수정했을 뿐인데, member2의 city가 같이 변경되는 사이드 이펙트가 발생함
            //값타입의 인스턴스를 공유해서 사용하면 안되고, 복사해서 새로 만들어야 함(new Address로 선언해서).
            //만약 공유해서 사용해야할 경우에는, Entity를 사용해야 함

            //객체 타입의 한계.
            // 항상 값을 복사해서 사용하면 공유 참조로 인해 발생하는 부작용을 피할수는 있다.
            //문제는 임베디드 타입처럼 직접 정의한 값 타입은 자바의 기본 타입이 아니라 객체 타입이다.
            //자바 기본 타입에 값을 대입하면 값을 복사한다.
            //객체 타입은 참조 값을 직접 대입하는 것을 막을 방법이 없다. (컴파일에서 걸러주지 않음)
            //객체의 공유 참조는 피할 수 없다.

            //기본 타입은 값을 복사. ex) int a = 10; int b = a; b =4; (기본 타입은 값을 복사하기 때문에 공유 현상이 나타나지 않음)
            //객체 타입은 참조를 전달 ex) Address a = new Address("old"); Address b = a; b.setCity("new"); (객체 타입은 참조를 전달하기 때문에 공유 현상이 일어남)

            //이걸 막기 위해서 불변 객체를 사용
            //객체 타입을 수정할 수 없게 만들면 부작용을 원천 차단
            //값 타입(VO)은 불변 객체로 설계해야함: 생성 시점 이후에 절대 값을 변경할 수 없는 객체
            //생성자로만 값을 설정하고 수정자를 만들지 않으면 됨

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
