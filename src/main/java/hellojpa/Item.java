package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(name="DTYPE")//자식 클래스에 DiscriminatorValue로 값을 지정할 수 있음.
public class Item {
	//Item을 상속받은 Album, Book, Movie가 기본적으로 Item SINGLE_TABLE(싱글테이블 전략)으로 생성됨
	//이걸 지정하고 싶으면 Inheritance(strategy=InherithenceType.JOINED or TABLE_PER_CLASS)로 지정하면 됨

	//JOINED는 각각 테이블에 저장함, 조회할때는 JOIN해서 가져옴. 이 전략을 사용할땐 DiscriminatorColumn 어노테이션을 사용하여 부모 클래스 객체에 DTYPE 필드에 자식 테이블 타입을 저장하도록 할것
	//SINGLE_TABLE전략은 DiscriminatorColumn 어노테이션을 사용하지 않아도 DTYPE이 기본적으로 생성됨. 필수기 때문

	//TABLE_PER_CLASS구현 클래스마다 테이블 전략 ITEM 테이블이 없이 MOVIE,BOOK, ALBUM 테이블에서 ITEM의 컬럼 가지는 전략 Discriminator 전략이 필요 없음
	//위 전략은 ITEM 형태로 객체를 조회하면, 모든 테이블을 다 JOIN해서 조회함. 비효율적

	//조인전략(정석) - 테이블이 정규화, 외래 키 참조 무결성 제약조건 활용가능. 설계가 깔끔, 저장공간 효율화 | 단점 조회시 조인을 많이 사용, 성능 저하, 조회 쿼리가 복잡함, 데이터 저장시 INSERT SQL 2번 호출
	//단일테이블 전략 -  조인이 필요 없으므로 일반적으로 조회 성능이 빠름, 조회 쿼리가 단순함 | 단점 자식 엔티티가 매핑한 컬럼은 모두 null 허용, 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있다.
	// 상황에 따라서 조회 성능이 오히려 느려질 수 있다.
	//구현클래스마다 테이블 전략(쓰면안됨) -  서브 타입을 명확하게 구분해서 처리할 때 효과적, not null 제약조건 사용 가능 | • 여러 자식 테이블을 함께 조회할 때 성능이 느림(UNION SQL 필요), 자식 테이블을 통합해서 쿼리하기 어려움
	@Id @GeneratedValue
	private Long id;

	private String name;
	private int price;

	public Item() {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
