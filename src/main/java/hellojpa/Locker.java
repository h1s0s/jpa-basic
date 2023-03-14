package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * packageName  : hellojpa
 * fileName     : Locker
 * author       : sshan
 * date         : 2023-03-14
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-14          sshan            최초생성
 */
@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
