package org.sky31.petstore.model;

/**
 * BaseQueryModel
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-10
 */
public class BaseQueryModel extends BaseModel
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8170826224785683978L;
	
	/**
	 * 默认分页条数
	 */
	public static final Long DEFAULT_PAGE_SIZE = 20L;
	
	/**
	 * 最大分页条数
	 */
	public static final Long MAX_PAGE_SIZE = 100 * DEFAULT_PAGE_SIZE;
	
	private Long currentPage = 1L;
	private Long pageSize = DEFAULT_PAGE_SIZE;
	
	public Long getCurrentPage()
	{
		return currentPage;
	}
	public Long getPageSize()
	{
		return pageSize;
	}
	public void setCurrentPage(Long currentPage)
	{
		this.currentPage = currentPage;
	}
	public void setPageSize(Long pageSize)
	{
		this.pageSize = pageSize;
	}
	
	public Long getStart()
	{
		currentPage = this.currentPage == null || this.currentPage < 1L ? 1L :  this.currentPage;
		pageSize = this.pageSize == null || this.pageSize > MAX_PAGE_SIZE ? DEFAULT_PAGE_SIZE : this.pageSize;
		
		return (currentPage - 1) * pageSize;
	}
	
	public Long getEnd()
	{
		currentPage = this.currentPage == null || this.currentPage < 1L ? 1L :  this.currentPage;
		pageSize = this.pageSize == null || this.pageSize > MAX_PAGE_SIZE ? DEFAULT_PAGE_SIZE : this.pageSize;
		
		return (currentPage - 1) * pageSize + pageSize;
	}
	
}
