package web.upload;

public class LogicException extends RuntimeException{
	private static final long serialVersionUID = 1L;
/**
 * 
 * @param message 异常信息
 * @param cause	异常的根本原因
 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LogicException(String message) {
		super(message);
	}
	
}
