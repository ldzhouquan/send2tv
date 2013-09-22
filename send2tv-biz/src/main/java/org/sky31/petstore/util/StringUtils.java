/**
 * CopyRright: taobao.com 
 * Project: top-userportal-biz
 * Create Date:2009.10.22
 * Version: 1.0 
 * JDK version used: JDK1.5
 */
package org.sky31.petstore.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

/**
 * @author wangxuzheng.tw
 * 
 */
public final class StringUtils {

	public static final String DEFAULT_CHARSET = "utf-8";
	
	
	/**
	 * 计算字符串长度，中文算两个字符，全角英文算两个字符
	 * 
	 * @param str
	 *            要计算的字符串，不可以为空
	 * @return
	 */
	public static int getStringActualLength(String str) {
		if (isBlank(str))
			return 0;

		int length = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isChineseChar(str.charAt(i))) {
				length += 2;
			} else {
				if (isFullSpaceChar(str.charAt(i))) {
					length += 2;
				} else {
					length++;
				}
			}
		}
		return length;
	}

	/**
	 * 判断是否为全角字符
	 * 
	 * @param ch
	 * @return
	 */
	private static boolean isFullSpaceChar(char ch) {
		return (ch >= 0xff00 && ch <= 0xffff);
	}

	/**
	 * 判断字符是不是中文字符
	 * 
	 * @param str
	 *            字符
	 * @return true 是中文字符，false 不是中文字符
	 * @author qingfeng 2009.10.26
	 */
	public static boolean isChineseChar(char str) {
		return (str >= 0x4e00 && str <= 0x9fbb);
	}
	
	
	/**
	 * 判断字符串中是否含有中文
	 * @param str
	 * @return
	 */
	public static boolean haveChineseChar(String str)
	{
		if(StringUtils.isBlank(str)){
			return false;
		}
		
		for(int i = 0; i < str.length(); i++){
			if(isChineseChar(str.charAt(i))){
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * 将oldStr中position的位置开始后的字符串替换为replacement add by chunchi for example:
	 * replace(0,"hello,everybody,i'm chunchi","sandbox"):
	 * "sandboxverybody,i'm chunchi"
	 * 
	 * @param position
	 * @param oldStr
	 * @param replacement
	 * @return
	 */
	public static String replace(int position, String oldStr, String replacement) {
		String pre = oldStr.substring(0, position);
		String post = oldStr.substring(position + replacement.length());
		return pre + replacement + post;
	}
	
	/**
	 * 得到字符的长度,中文作为两个字符来记录
	 * @param str 需要计算长度的字符	
	 * @return 字符串长度
	 * @author qingfeng 2009.10.26
	 */
	public static int  getStringLength(String str) {
		int length = 0;
		for(int i=0;i<str.length();i++) {
			if(isChineseChar(str.charAt(i))) { length+=2;}
			else {length ++;}
		}
		return length;
	}


	/**
	 * 检查字符串是不是手机号码
	 * @param str 需要检查的字符串
	 * @return true：是手机号码 ，false ：不是手机号码
	 * @author qingfeng 2009.10.26
	 */
	public  static boolean  isMobile(String str) {
		if(isBlank(str) || str.length() !=11) {
			return false;
		}
		String reg = "^(((13[0-9]{1})|(18[0-9]{1})|(15[0-9]{1}))+\\d{8})$";
		return Pattern.compile(reg).matcher(str).matches();
	}
	
	
	/**
	 * 检查字符串是不是普通字符串
	 * @param str 需要检查的字符串
	 * @return true：是 ，false ：不是
	 * @author qingfeng 2009.10.26
	 */
	public static boolean isCommonString(String str){
		if(isBlank(str)) {
			return false;
		}
		String reg = "^[.a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
		return Pattern.compile(reg).matcher(str).matches();
	}
	
	
	/**
	 * 检查字符串是不是电话号码
	 * @param str 需要检查的字符串
	 * @return true：是电话号码 ，false ：不是电话号码
	 * @author qingfeng 2009.10.26
	 */
	public static boolean  isTelephone(String telephone){
		if(isBlank(telephone)) {
			return false;
		}
		String reg = "^(([0\\+]\\d{2,3}-)?(0\\d{2,4})-)(\\d{7,8})(-(\\d{2,}))?$";
		return Pattern.compile(reg).matcher(telephone).matches();
	}
	
	
	/**
	 * 检查字符串是不是url地址
	 * @param str 需要检查的字符串
	 * @return true：是url地址 ，false ：不是url地址
	 * @author qingfeng 2009.10.26
	 */
	public static boolean  isUrl(String str) {
		if(isBlank(str)) {
			return false;
		}
		String reg = "^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$";
		return Pattern.compile(reg).matcher(str).matches();
	}
	
	
	/**
	 * 检查字符串是不是邮箱地址
	 * @param str 需要检查的字符串
	 * @return true：是邮箱地址 ，false ：不是邮箱地址
	 * @author qingfeng 2009.10.26
	 */
	public static boolean  isEmail(String str) {
		if (isBlank(str)) {
			return false;
		}
		String reg = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
		return Pattern.compile(reg).matcher(str).matches();
	}
	
	/**
	 * 
	 * @param value 判断value是否在long串数组里存在
	 * @return true 存在 false 不存在
	 */
	public static boolean isExitArray(long value,long[] array){
		boolean flag=false;

		if (StringUtils.isBlank(Long.valueOf(value).toString())){
			return flag;
		}
		if (array==null || array.length==0){
			return flag;
		}
		for(long temp:array){
			if (value==temp){
				flag=true;
				break;
			}
		}
		return false;
	}

/**
 * 
 * @param value 判断value字符串是否在字符串数组里存在
 * @param array 字符串数组
 * @return true 存在 false 不存在
 */
	public static boolean isExitStringArray(String value,String[] array){
		boolean flag=false;
		if (StringUtils.isBlank(value)){
			return flag;
		}
		if (array==null || array.length==0){
			return flag;
		}
		for(String temp:array){
			if (value.equals(temp)){
				flag=true;
				break;
			}
		}
		return false;
	}
	
	
	/**
	 * 判斷字符串是否為空白
	 * str == null 		 	true
	 * str == ""			true
	 * str == "    "		true
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		
		if(str == null){
			return true;
		}
		
		if(str.trim().length() == 0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 取得形如123123123-0字符串"-"符号前的字符串
	 * @param str
	 * @return
	 */
	public static String getSubString(String str, String regex)
	{
		if (str == null)
		{
			return null;
		}
		String[] tmpStr = str.split(regex);
		return tmpStr[0];
	}
	

	/**
	 * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
	 * <pre>
	 * SubStringUtil.substring("abc",8,"...")        =      "abc...";
	 * SubStringUtil.substring("",8,"...")           =      "";
	 * SubStringUtil.substring("abcd",1,"...")       =      "a...";
	 * </pre>
	 * @param origin
	 *            原始字符串
	 * @param len
	 *            截取长度(一个汉字长度按2算的)
	 * @param subfix
	 *            后缀
	 * @return 返回的字符串
	 */
	public static String substring(String origin, int len, String subfix) {
		if (origin == null || origin.equals("") || len < 1)
			return "";
		byte[] strByte = new byte[len];
		if (len > getStringActualLength(origin)) {
			return origin + subfix;
		}
		try {
			System.arraycopy(origin.getBytes("GBK"), 0, strByte, 0, len);
			int count = 0;
			for (int i = 0; i < len; i++) {
				int value = (int) strByte[i];
				if (value < 0) {
					count++;
				}
			}
			if (count % 2 != 0) {
				len = (len == 1) ? ++len : --len;
			}
			return new String(strByte, 0, len, "GBK") + subfix;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	

	public static String decode(String value){
		return decode(value, DEFAULT_CHARSET);
	}
	/**
	 * 对字符串进行utf-8解码
	 * 
	 * @param value
	 * @return
	 */
	public static String decode(String value, String chareset) {
		if (value == null || value.trim().equals("")) {
			return null;
		}
		if (value.trim().equalsIgnoreCase("null")) {
			return value.trim();
		}
		try {
			return URLDecoder.decode(value.trim(), chareset);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	/**
	 * 格式化版本号，1—>01,2—>02
	 * 
	 * @param version
	 * @return
	 */
	public static String getFormatVersion(int version){
		if(version < 0){
			return null;
		}
		if(version != 0 && version < 10){
			return "0" + String.valueOf(version);
		}else{
			return String.valueOf(version);
		}
	}
	
	/**
	 * 1.可以使用字符作为一个通配符来代替除换行符(\n)之外的任意一个字符,例如:
	 * .at可以与"cat","sat","mat"等匹配.通常,这种通配符用于操作系统中文件名匹配.
	 * 2.[a-z]at,任何含在[]中的内容都是一个字符,只匹配一个字符.
	 * 如:[a-zA-Z]代表所有大小写字母.
	 * 3.[^a-z].匹配任何不属于a-z中的字符.
	 * 4.[a-z&&[hij]].匹配hij任何一个(交集)
	 * 5.\s.匹配空字符(空格,tab,\n,换页,回车)
	 * 6.\S.匹配非空字符(和[^\s]一样)
	 * 7.\d.匹配数字,相当于[0-9]
	 * 8.\D.匹配非数字,相当于[^0-9],匹配中文,空格,换行符
	 * 9.\w.匹配词字符,相当于[a-zA-Z0-9],不包含中文,不能代表空格,换行符
	 * 10.\W.匹配非词字符,相当于[^\w],匹配一个中文字
	 * 逻辑运算符:
	 * |:管道符.如:x|y表示x或y
	 * ():捕获组.(abc)|(xyz)表示abc或xyz
	 * 边界匹配符:
	 * ^:从头匹配
	 * $:从尾匹配
	 * \b:词界.
	 * \B.非词界
	 * 量词:
	 * 量词描述一个模式吸收输入文本的方式.
	 *:前面字符或组匹配0或多个
	 * +:前面字符或组匹配1或多个
	 * ?:前面字符或组匹配0或1个
	 * {n}:前面字符或组的数量为n个
	 * {n,}:前面字符或组的数量至少n个
	 * {n,m}:前面字符或组数量至少n个,最多m个
	 */
}
