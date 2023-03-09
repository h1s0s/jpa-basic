package hellojpa;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

/**
 * packageName  : hellojpa
 * fileName     : GenerationMember
 * author       : sshan
 * date         : 2023-03-09
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-09          sshan            최초생성
 */
@Entity
public class GenerationMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id값 셋팅을 빼고 넣으면 기본키로 지정해둔 컬럼값을 자동으로 셋팅해줌
    //GenerationType.Auto 오라클이면 시퀀스, 방언에 따라 자동 지정, 기본값
    //
    // .IDENTITY 기본키 생성을 데이터베이스에 위임
    // insert 되는 시점에 생성되기에 제약이 있음, 이걸 사용하면 persist를 날리는 시점에 insert 쿼리가 날라감
    // 모아서 insert할때 문제가 있음(써봐야알듯)
    //
    // .SEQUENCE 시퀀스 오브젝트를 자동으로 만들고 사용함, 정수로 들어가니 필드 자료형도 맞춰줄것
    //시퀀스의 경우엔 Entity에 @SequenceGenerator를 사용해 시퀀스를 정의, 생성해주고
    //generator 속성으로 생성되어있는 시퀀스를 지정해 줄 수 있다.
    //
    // .TABLE 키 생성 전용 테이블을 만듬. 성능이 좀 떨어진다는 단점, 운영에서는 좀 부담스러움
    private String Id;

    @Column(name="name", nullable = false)
    private String username;

    public GenerationMember() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
