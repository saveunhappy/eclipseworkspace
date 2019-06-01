package cascade;

public interface ISaleBillDAO {
	void save(SaleBill bill);
	
	void update(SaleBill bill);
	
	void delete(Long id);
	
	SaleBill get(Long id);

}
