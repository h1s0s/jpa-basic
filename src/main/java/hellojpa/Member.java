package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * packageName  : hellojpa
 * fileName     : Member
 * author       : sshan
 * date         : 2023-02-26
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-02-26          sshan            최초생성
 */

@Entity
//@Table(name="USER") //클래스명과 테이블명 다를때
public class Member extends BaseEntity{

    @Id
    private Long id;

    //@Column(name = "username", unique = true, length = 10)// 컬럼명 다를때 name
    //unique 제약조건, length 글자수제한(DDL 생성기능에 간섭되는 부분임, JPA 실행 로직과는 연관X)



    @Column(name = "name"
//            insertable = true, updatable = true, //1. insertable, updateble 인서트문이나 업데이트문이 플러쉬 될때 반영 할지말지 여부(기본값 O)
//            ,nullable = false //2. nallable : false면 not null 제약조건, 이방법은 업데이트문이 날라갈때 이름이 랜덤하게 날라감
                                // 그래서 이 방법은 잘 안쓰고 주로 @Table 태그의 uniqueConstraints를 쓴다
//            , columnDefinition = "varchar(100) default 'EMPTY'" //3. 컬럼 정보를 직접 줄 수 있다
    )
    private String username;

    private Integer age;

    // EnumType은 ORDINAL, STRING 2개가 있고 기본적으로 ORDINAL이 들어감
    // ORDINAL은 이넘 필드 순서대로 숫자로 들어감. ex) 0,1,2,3
    // ORDINAL을 쓰면 안좋은 이유는, 나중에 새로운 필드가 추가 되었을때 순서에 의한 큰 문제가 생길 우려가 있음
    // STRING은 ENUM의 문자 그대로 들어감
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //LocalDate는 날짜 - date 타입으로 매핑됨
    private LocalDate testLocalDate;
    //일시 - timestamp 타입으로 매핑됨
    private LocalDateTime testLocalDateTime;

    @Lob //속성이 따로 없음, 문자열이면 CLOB,나머지는 BLOB으로 매핑
    private String description;

    @Transient//매핑X 어노테이션
    private int temp;

    //엔티티에 기본생성자 필수
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDate getTestLocalDate() {
        return testLocalDate;
    }

    public void setTestLocalDate(LocalDate testLocalDate) {
        this.testLocalDate = testLocalDate;
    }

    public LocalDateTime getTestLocalDateTime() {
        return testLocalDateTime;
    }

    public void setTestLocalDateTime(LocalDateTime testLocalDateTime) {
        this.testLocalDateTime = testLocalDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
