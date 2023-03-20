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

    @ManyToOne(fetch = FetchType.LAZY)//단방향 연관관계일때 1:다, 다인 쪽일땐 ManyToOne 1인 쪽에선 OneToMany
    //fetchType.LAZY 지연로딩을 사용해서 프록시로 조회
    //fetchType.EAGER 즉시로딩 생성할때 함께 조회
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)//1:1
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRDUCT")//다대다 관계를 관계형 데이터베이스에서는, 중간에 테이블을 하나 생성하여 관계를 풀어냄
    private List<Product> products = new ArrayList<>();

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({//임베디드를 여러개 쓸때, 컬럼명이 겹치는 문제가 발생되는데 해당 어노테이션으로 처리 가능
        @AttributeOverride(name="city", column=@Column(name = "WORK_CITY")),
        @AttributeOverride(name="street", column=@Column(name = "WORK_STREET")),
        @AttributeOverride(name="zipCode", column=@Column(name = "WORK_ZIPCODE"))
    })
    private Address workAddress;


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

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public void getName(String member1) {
    }
}