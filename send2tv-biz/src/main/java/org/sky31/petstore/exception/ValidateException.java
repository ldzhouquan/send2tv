package org.sky31.petstore.exception;

/**
 * 参数验证出错异常
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-12
 */
public class ValidateException extends Exception
{

	private static final long serialVersionUID = 3574639653323097983L;

	public ValidateException(Throwable t)
	{
		super(t);
	}
	
	public ValidateException(String msg)
	{
		super(msg);
	}
	
	public ValidateException(String msg, Throwable t)
	{
		super(msg, t);
	}
}
