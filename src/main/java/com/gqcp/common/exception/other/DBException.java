package com.gqcp.common.exception.other;

/**
 * 类说明：数据库异常类
 * @author liyufu
 * @version 1.0
 */
public class DBException extends Exception{
	private static final long serialVersionUID = 1L;

	public DBException() {
        super();
    }
    
    public DBException(String msg) {
        super(msg);
    }
    
    public DBException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public DBException(Throwable cause) {
        super(cause);
    }
}
