package ExceptionDemo;

public class Register {
	private static String[] names = {"will","lili","lucy"};
	
	public static void main(String[] args) {
		try {
			checkUername("will");
			System.out.println("注册成功");
		} catch (LogicException | ArithmeticException e) {
			//getMessage  获取错误的信息
			String err = e.getMessage();
			System.out.println("给用户看"+err);
		}
		
		
	}
	public static boolean checkUername(String username) {
			for(String name : names) {
				if(name.equals(username)){
					throw new LogicException("亲"+name+"已经被注册了");
				}
			}
			return true;
	}
}
