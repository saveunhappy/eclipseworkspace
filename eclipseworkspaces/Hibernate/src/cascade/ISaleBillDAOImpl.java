package cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.util.HibernateUtil;

public class ISaleBillDAOImpl implements ISaleBillDAO {

	@Override
	public void save(SaleBill bill) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(bill);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 用于处理在编辑的时候修改了明细或者添加了新的明细
	 * @param bill
	 */
	public void update1(SaleBill bill) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(bill);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void delete(Long id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		SaleBill bill = (SaleBill)session.get(SaleBill.class, 1L);
		session.delete(bill);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public SaleBill get(Long id) {
		
		Session session = HibernateUtil.getSession();
		SaleBill bill = (SaleBill) session.get(SaleBill.class, 1L);
		Hibernate.initialize(bill.getItems());
		session.close();
		return bill;
	}

	/**
	 * 用于在编辑的时候删除了明细
	 */
	@Override
	public void update(SaleBill bill) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		//1.找到哪些明细被删除了
		//old是以前的数据，完整的数据
		SaleBill old = (SaleBill)session.get(SaleBill.class,bill.getId());
		//准备一个集合来存放找到的被删除的数据
		List<SaleBillItem> deletes = new ArrayList<>();
		//对比数据是否被删除(用老的比新的)
		for(SaleBillItem oldItem : old.getItems()) {
			boolean find = false;
			for(SaleBillItem newItem: bill.getItems()) {
				if(oldItem.getId().equals(newItem.getId())) {
					find = true;
					break;
				}
			}
			if(!find) {
				deletes.add(oldItem);
				//被删除的数据不再属于任何订单了
				oldItem.setBill(null);
			}
		}
		//打破明细对象和主对象的关系
		//从老的数据中删除已经删除的数据
		old.getItems().removeAll(deletes);
		//再调用session的update方法去修改
		//注意：这个地方不能修改bill
		//1:修改bill没有任何作用
		//2：修改bill会在hibernate中产生两个主键相同，类型相同的持久化对象，hibernate会报错！！！
		session.update(old);
		session.getTransaction().commit();
		session.close();
	}

}
