package com.ruoyi.project.ls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.ls.domain.Blog;
import com.ruoyi.project.ls.pub.mapper.BlogMapper;

/**
 * 公告 服务层实现
 * 
 * @author ruoyi
 * @date 2018-06-25
 */
@Service
public class BlogServiceImpl implements IBlogService
{
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private IBlogReplyService blogReplyService;
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public Blog selectNoticeById(Integer noticeId)
    {
        return blogMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<Blog> selectNoticeList(Blog notice)
    {
        return blogMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(Blog notice)
    {
        return blogMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(Blog notice)
    {
        return blogMapper.updateNotice(notice);
    }

    /**
     * 保存公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int saveNotice(Blog notice)
    {
        Integer noticeId = notice.getNoticeId();
        int rows = 0;
        if (StringUtils.isNotNull(noticeId))
        {
            notice.setUpdateBy(ShiroUtils.getLoginName());
            // 修改公告
            rows = blogMapper.updateNotice(notice);
        }
        else
        {
            notice.setCreateBy(ShiroUtils.getLoginName());
            // 新增公告
            rows = blogMapper.insertNotice(notice);
        }
        return rows;
    }

    /**
     * 删除公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids)
    {
        return blogMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }

    
    /**
     * 根据创建人查询
     * @param createBy
     * @return
     */
	@Override
	public List<Blog> listByCreator(Blog notice) {
		return blogMapper.listByCreator(notice);
	}

	@Override
	public int addViewCount(Integer noticeId) {
		return blogMapper.addViewCount(noticeId);
	}

	@Override
	public int addReplyCount(Integer noticeId,String replyContent) {
		blogReplyService.addReply(noticeId,replyContent);
		return blogMapper.addReplyCount(noticeId);
	}

}
