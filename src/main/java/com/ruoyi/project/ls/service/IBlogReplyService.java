package com.ruoyi.project.ls.service;

import java.util.List;

import com.ruoyi.project.ls.domain.BlogReply;

/**
 * 公告 服务层
 * 
 * @author ruoyi
 */
public interface IBlogReplyService{

	 /**
     * 查询公告回答列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<BlogReply> selectNoticeList(Integer noticeId);

    
	public int addReply(Integer noticeId, String replyContent);


}
