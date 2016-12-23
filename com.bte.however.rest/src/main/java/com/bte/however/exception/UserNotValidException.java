/**
 * 
 */
package com.bte.however.exception;

/**
 * Excepcion lanzada cuando el usuario no es válido por que la contraseña no
 * coincide,
 * 
 * @author benauca
 *
 */
public class UserNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UserNotValidException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public UserNotValidException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public UserNotValidException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UserNotValidException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public UserNotValidException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
