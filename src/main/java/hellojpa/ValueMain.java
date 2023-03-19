package hellojpa;

/**
 * packageName  : hellojpa
 * fileName     : ValueMain
 * author       : sshan
 * date         : 2023-03-19
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-03-19          sshan            최초생성
 */
public class ValueMain {

    public static void main(String[] args) {
        //값타입은 공유하지 않음(사이드 이펙트가 발생하지 않음). 하지만 Integer같은 래퍼 클래스나 String 같은 특수한 클래스는 공유 가능한 객체(같은 인스턴스를 공유)
        //그래서 값을 변경하면 그 주솟값을 가진 변수들의 값이 다 변경됨
    }
}
