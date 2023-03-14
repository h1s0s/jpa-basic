package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
public class Member3 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @ManyToOne//단방향 연관관계일때 1:다, 다인 쪽일땐 ManyToOne 1인 쪽에선 OneToMany
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne//1:1
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @ManyToMany//다대다
    @JoinTable(name = "MEMBER_PRDUCT")//다대다 관계를 관계형 데이터베이스에서는, 중간에 테이블을 하나 생성하여 관계를 풀어냄
    private List<Product> products = new ArrayList<>();

    public Member3() {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}