package com.ruoyi.project.ls.pub.mapper;

import java.util.List;
import com.ruoyi.project.ls.domain.Blog;

/**
 * 公告 数据层
 * 
 * @author ruoyi
 */
public interface BlogMapper
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
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);

    /**
     * 根据创建人查询
     * @param createBy
     * @return
     */
	public List<Blog> listByCreator(Blog notice);

	
	public int addViewCount(Integer noticeId);

	public int addReplyCount(Integer noticeId);

}