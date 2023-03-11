package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName  : hellojpa
 * fileName     : Team
 * author       : sshan
 * date         : 2023-03-11
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-11          sshan            최초생성
 */
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //mappedBy를 사용한 엔티티가 주인(owner)가 됨
    //이 개념이 어려우니 공부 필
    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<Member>();

    public Team() {
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
