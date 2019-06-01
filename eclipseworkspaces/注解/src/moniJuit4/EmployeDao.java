package moniJuit4;

public class EmployeDao {
	@MyBefore
	public void init() throws Exception {
		System.out.println("≥ı ºªØ");
	}
	@MyAfter
	public void destory() throws Exception {
		System.out.println("œ˙ªŸ");

	}
	@MyTest
	public void testSave() throws Exception {
		System.out.println("≤‚ ‘±£¥Ê");

	}
	@MyTest
	public void teseDelete() throws Exception {
		System.out.println("≤‚ ‘…æ≥˝");

	}
}
