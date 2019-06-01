package ExceptionDemo;

public class LogicException extends RuntimeException{
	private static final long ID = 1l;

	public LogicException() {
		super();
	}
	/**
	 * 
	 * 
	 * @param message  表示当前异常的原因/信息
	 * @param cause		当前异常的根本原因
	 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LogicException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
