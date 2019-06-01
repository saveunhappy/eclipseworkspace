package cascade;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * 销售订单
 * @author HJT
 *
 */
@Getter@Setter
public class SaleBill {
	private Long id;
	private String sn;
	private Set<SaleBillItem> items = new HashSet<>();
	@Override
	
	public String toString() {
		return "SaleBill [id=" + id + ", sn=" + sn + "]";
	}
	
}
