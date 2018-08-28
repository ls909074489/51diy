package com.ruoyi.project.ls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.ls.domain.BlogReply;
import com.ruoyi.project.ls.pub.mapper.BlogReplyMapper;

/**
 * 公告 服务层实现
 * 
 * @author ruoyi
 * @date 2018-06-25
 */
@Service
public class BlogReplyServiceImpl implements IBlogReplyService
{
    @Autowired
    private BlogReplyMapper noticeReplyMapper;

	@Override
	public List<BlogReply> selectNoticeList(Integer noticeId) {
		return noticeReplyMapper.selectNoticeList(noticeId);
	}

	@Override
	public int addReply(Integer noticeId, String replyContent) {
		BlogReply reply=new BlogReply();
		reply.setNoticeId(noticeId);
		reply.setReplyContent(replyContent);
		return noticeReplyMapper.addReply(reply);
	}


}
