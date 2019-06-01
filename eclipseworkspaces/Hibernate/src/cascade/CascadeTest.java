package cascade;
/**
 * 组合关系的测试代码
 * @author HJT
 *
 */

import org.junit.Before;
import org.junit.Test;

public class CascadeTest {
	private ISaleBillDAO dao;
	
	public  CascadeTest() {
		dao = new ISaleBillDAOImpl();
	}
	
	
	@Before
	public void testSave() throws Exception {
		SaleBill bill = new SaleBill();
		bill.setSn("001");
		
		SaleBillItem item1 = new SaleBillItem();
		item1.setProduct("p1");
		item1.setBill(bill);

		SaleBillItem item2 = new SaleBillItem();
		item2.setProduct("p2");
		item2.setBill(bill);
		
		SaleBillItem item3 = new SaleBillItem();
		item3.setProduct("p3");
		item3.setBill(bill);
		bill.getItems().add(item1);
		bill.getItems().add(item2);
		bill.getItems().add(item3);
		
		dao.save(bill);
	}
	
	@Test
	public void testUpdate() throws Exception {
		//这个更新是把主对象更新之后，副对象也会更新
		SaleBill bill = this.dao.get(1L);
		bill.setSn("002");
		bill.getItems().iterator().next().setProduct("updateProduct");
		SaleBillItem item4 = new SaleBillItem();
		item4.setProduct("p4");
		item4.setBill(bill);
		bill.getItems().add(item4);
		dao.update(bill);
	}
	@Test
	public void testUpdate2() throws Exception {
		SaleBill bill = this.dao.get(1L);
		//这个把里面的一条数据删除，但是update只会更新和主对象关系的从对象，这里已经删除了一条数据，所以更新和这个没鸡毛关系
		SaleBillItem item = bill.getItems().iterator().next();
	
		bill.getItems().remove(item);
		dao.update(bill);
	}
	@Test
	public void testDelete() {
		dao.delete(1L);
	}
}
