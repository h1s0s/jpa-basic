package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * packageName  : hellojpa
 * fileName     : Member2
 * author       : sshan
 * date         : 2023-03-11
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-11          sshan            최초생성
 */
@Entity
public class Member4 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @Embedded
    private Address homeAddress;

    @ElementCollection//값 컬렉션
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name="MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")//SET은 값이 1개이기 때문에, 컬럼명을 지정해주어야 함
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection//값 컬렉션
    @CollectionTable(name = "ADDRESS", joinColumns =
        @JoinColumn(name="MEMBER_ID")//조인 컬럼명
    )//생성되는 테이블 명
    private List<Address> addressHistory = new ArrayList<>();

    //값타입 컬렉션은 테이블임에도 불구하고 특별한 설정 없이도 member가 persist갈때 한번에 업데이트 됨
    //영속성 전이 + 고아 객체 제거기능을 필수로 가진다고 볼 수 있다.
    //조회할때는 지연로딩으로 조회됨(사용할때 조회함)

    //중요
    //값타입 컬렉션에 변경사항이 발생하면, 주인 엔티티와 연관된 모든 데이터를 삭제하고
    //값타입 컬렉션에 있는 현재 값을 모두 저장한다.
    //이 문제 때문에 이 방법은 애초에 쓰지 않는게 좋다는 결론.. => Entity를 생성하는게 나음

    public Member4() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }


    public void getName(String member1) {
    }
}