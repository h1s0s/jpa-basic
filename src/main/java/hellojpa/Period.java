package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable//임베디드 선언
public class Period {

	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Period() {//기본생성자 있어야함
	}
}
