package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * packageName  : hellojpa
 * fileName     : Product
 * author       : sshan
 * date         : 2023-03-14
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-14          sshan            최초생성
 */

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public Product() {
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
