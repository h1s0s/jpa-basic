package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Member {

    @Id
    private Long id;

    //@Column(name = "username")// 컬럼명 다를때
   private String name;

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
