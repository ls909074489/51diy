package com.ruoyi.project.ls.service;

import java.util.List;

import com.ruoyi.project.ls.domain.Blog;

/**
 * 公告 服务层
 * 
 * @author ruoyi
 */
public interface IBlogService
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public Blog selectNoticeById(Integer noticeId);

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<Blog> selectNoticeList(Blog notice);

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(Blog notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(Blog notice);

    /**
     * 保存公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int saveNotice(Blog notice);

    /**
     * 删除公告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String ids);

    /**
     * 根据创建人查询
     * @param createBy
     * @return
     */
	public List<Blog> listByCreator(Blog notice);

	/**
	 * 查看次数+1
	 * @param noticeId
	 * @return
	 */
	public int addViewCount(Integer noticeId);
	
	/**
	 * 回复次数+1
	 * @param noticeId
	 * @return
	 */
	public int addReplyCount(Integer noticeId,String replyContent);

}
