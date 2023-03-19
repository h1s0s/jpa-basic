package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName  : hellojpa
 * fileName     : Parent
 * author       : sshan
 * date         : 2023-03-19
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-19          sshan            최초생성
 */
@Entity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)//cascade는 부모타입인 Parent를 persist할때, 연관 객체(자식객체)도 같이 persist 해줌
    //연관관계를 매핑해주는 것이 아닌 편의를 위한것
    //ALL 모두 적용 / PERSISTE 영속 / REMOVE 삭제 / MERGE 병합 / REFRESH 리프레쉬 / DETACH 디태치

    //orphanRemoval = true : 컬렉션에서 빠진 애는 delete해줌. 참조하는 곳이 하나일때 사용할 것
    //cascade의 REMOVE와는 다른게, 이건 부모객체가 지워졌을때 자식도 같이 지워지는 거임. 말그대로 전이, 전파
    private List<Child> childList = new ArrayList<>();

    //연관관계 편의 메서드
    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }

    public Parent() {
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
}
