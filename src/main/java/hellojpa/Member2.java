package hellojpa;

import javax.persistence.*;

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
public class Member2 {

    @Id
    @GeneratedValue//기본키
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @ManyToOne//단방향 연관관계일때 1:다, 다인 쪽일땐 ManyToOne 1인 쪽에선 OneToMany
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member2() {
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