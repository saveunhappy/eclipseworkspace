package cascade;

import lombok.Getter;
import lombok.Setter;

/**
 * 销售订单明细
 * @author HJT
 *
 */
@Getter@Setter
public class SaleBillItem {
	private Long id;
	private String product;
	private SaleBill bill;
	
	@Override
	public String toString() {
		return "SaleBillItem [id=" + id + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleBillItem other = (SaleBillItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
