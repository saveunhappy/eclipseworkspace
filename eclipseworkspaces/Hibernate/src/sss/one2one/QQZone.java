package sss.one2one;

import lombok.Getter;
import lombok.Setter;

/**
 * QQ空间
 * @author HJT
 *
 */
@Setter@Getter
public class QQZone {
	private Long id;
	private String title;
	private QQNumber number;
	@Override
	public String toString() {
		return "QQZone [id=" + id + ", title=" + title + "]";
	}
	
}
