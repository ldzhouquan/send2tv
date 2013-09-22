package org.sky31.petstore.util;

/**
 * 位操作工具类
 * 
 * @author sihai
 */
public class BitUtil {

	// ===========================================
	// For int
	// ===========================================
	/**
	 * 检测十进制数的第position位是否被置位(为1)
	 * 
	 * @param data 被检测的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return 如果data的第position位为1(被置位)，返回true 如果data的第position位为0(被清零)，返回false
	 */
	public static boolean isSet(int data, int position) {

		assert (position > 0 && position <= Integer.SIZE);

		int index = position - 1;

		if ((data & (1 << index)) == (1 << index)) {
			return true;
		}

		return false;
	}

	/**
	 * 检测十进制数的第position位是否被清零(为0)
	 * 
	 * @param data 被检测的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return 如果data的第position位为0(被清零)，返回true 如果data的第position位为1(被置位)，返回false
	 */
	public static boolean isClear(int data, int position) {
		return !isSet(data, position);
	}

	/**
	 * 将十进制数的第position位置位(设为1)
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static int set(int data, int position) {
		assert (position > 0 && position <= Integer.SIZE);

		int index = position - 1;

		return data | (1 << index);
	}

	/**
	 * 将十进制数的第position位清零(设为0)
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static int clear(int data, int position) {
		assert (position > 0 && position <= Integer.SIZE);

		int index = position - 1;

		return data & ~(1 << index);
	}

	/**
	 * 取得十进制数的第position位的值
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static int bit(int data, int position) {
		assert (position > 0 && position <= Integer.SIZE);

		int index = position - 1;
		return data & (1 << index);
	}

	// ===========================================
	// For long
	// ===========================================

	/**
	 * 检测十进制数的第position位是否被置位(为1)
	 * 
	 * @param data 被检测的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return 如果data的第position位为1(被置位)，返回true 如果data的第position位为0(被清零)，返回false
	 */
	public static boolean isSet(long data, int position) {

		assert (position > 0 && position <= Long.SIZE);

		int index = position - 1;

		if ((data & (1L << index)) == (1L << index)) {
			return true;
		}

		return false;
	}

	/**
	 * 检测十进制数的第position位是否被清零(为0)
	 * 
	 * @param data 被检测的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return 如果data的第position位为0(被清零)，返回true 如果data的第position位为1(被置位)，返回false
	 */
	public static boolean isClear(long data, int position) {
		return !isSet(data, position);
	}

	/**
	 * 将十进制数的第position位置位(设为1)
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static long set(long data, int position) {
		assert (position > 0 && position <= Long.SIZE);

		int index = position - 1;

		return data | (1L << index);
	}
	
	/**
	 * 将十进制数的第position位置位(设为1)
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static long set(long data, int... position) {
		for (int i = 0, length = position.length; i < length; i++) {
			data = set(data, position[i]);
		}
		return data;
	}

	/**
	 * 将十进制数的第position位清零(设为0)
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static long clear(long data, int position) {
		assert (position > 0 && position <= Long.SIZE);

		int index = position - 1;

		return data & ~(1L << index);
	}

	/**
	 * 取得十进制数的第position位的值
	 * 
	 * @param data 被操作的十进制数
	 * @param position 二进制第position位，从左开始第一位
	 * @return
	 */
	public static long bit(long data, int position) {
		assert (position > 0 && position <= Long.SIZE);

		int index = position - 1;
		return data & (1L << index);
	}
	
}
