package sss.one2one;

import lombok.Getter;
import lombok.Setter;

/**
 * QQ号
 * @author HJT
 *
 */
@Getter@Setter
public class QQNumber {
	private Long id;
	private String number;
	private QQZone zone;
	@Override
	public String toString() {
		return "QQNumber [id=" + id + ", number=" + number + "]";
	}
	
}
