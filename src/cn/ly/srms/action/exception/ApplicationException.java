package cn.ly.srms.action.exception;

/**
 * <p>Title: </p>
 * <p>Description:系统异常</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: 雁联</p>
 * @author 郭兵
 * @version 1.0
 */
public class ApplicationException extends Exception {

	private String code; //错误码
	private String message; //错误描述
	private Exception exception; //底层异常

	/**
	 * Creates a new SysException wrapping another exception, and with a detail message.
	 * @param message the detail message.
	 * @param exception the wrapped exception.
	 */
	public ApplicationException(String code, String message, Exception exception) {
		super(message);
		this.code = code;
		this.message = message;
		this.exception = exception;
		return;
	}

	/**
	 * Creates a SysException with the specified detail message.
	 * @param message the detail message.
	 */
	public ApplicationException(String code, String message) {
		this(code, message, null);
		return;
	}

	//@todo
	public  ApplicationException(String message, Exception e) {
		this(null, message, e);
	}
	
	public ApplicationException(String message) {
		this(null, message, null);
	}
	
	public ApplicationException(Exception e){
		this(null, null, e);
	}
	
	/**
	 * Constructor default
	 */
	public ApplicationException() {
		super();
	}
	
	/**
	 * 获取错误码.
	 *
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 获取错误描述.
	 *
	 * @return
	 */
	public String getNotes() {
		return message;
	}

	/**
	 * Gets the wrapped exception.
	 *
	 * @return the wrapped exception.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Retrieves (recursively) the root cause exception.
	 *
	 * @return the root cause exception.
	 */
	public Exception getRootCause() {
		if (exception instanceof ApplicationException) {
			return ((ApplicationException) exception).getRootCause();
		}
		return exception == null ? this : exception;
	}

	public String toString() {
		String desc = "Errror description ：" + message;
		if (exception != null){
			desc = desc + ",Underlayer exception ：" + exception;
		}
		return desc;	
	}

}
