package org.sky31.petstore.domain;

/**
 * 宠物类
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-10
 */
public class PetDO extends BaseDO{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4646736639954388435L;

	/**
	 * 宠物的名字
	 */
	private String name;
	
	/**
	 * 宠物的类型
	 */
	private Long type;
	
	/**
	 * 是否已被卖出（逻辑删除）
	 */
	private Long isSelled;
	
	/**
	 * 颜色
	 */
	private String color;
	
	/**
	 * 描述或备注（以Json格式存储）
	 */
	private String description;
	
	/**
	 * 重量
	 */
	private Double weight;
	
	/**
	 * 高度
	 */
	private Double height;

	/**
	 * 获取name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置name
	 * 
	 * @param name 要设置的name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取type
	 * 
	 * @return type
	 */
	public Long getType() {
		return type;
	}

	/**
	 * 设置type
	 * 
	 * @param type 要设置的type
	 */
	public void setType(Long type) {
		this.type = type;
	}

	/**
	 * 获取isSelled
	 * 
	 * @return isSelled
	 */
	public Long getIsSelled() {
		return isSelled;
	}

	/**
	 * 设置isSelled
	 * 
	 * @param isSelled 要设置的isSelled
	 */
	public void setIsSelled(Long isSelled) {
		this.isSelled = isSelled;
	}

	/**
	 * 获取color
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 设置color
	 * 
	 * @param color 要设置的color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 获取description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description 要设置的description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取weight
	 * 
	 * @return weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * 设置weight
	 * 
	 * @param weight 要设置的weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * 获取height
	 * 
	 * @return height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * 设置height
	 * 
	 * @param height 要设置的height
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	
}
