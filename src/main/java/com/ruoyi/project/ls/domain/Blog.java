package com.ruoyi.project.ls.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 公告表 sys_notice
 * 
 * @author ruoyi
 */
public class Blog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Integer noticeId;
    /** 公告标题 */
    private String noticeTitle;
    /** 公告类型（1通知 2公告） */
    private String noticeType;
    /** 公告内容 */
    private String noticeContent;
    /** 公告状态（0正常 1关闭） */
    private String status;
    
    private Integer viewCount=0;//查看次数
    
    private Integer replyCount=0;//回复次数

    public void setNoticeId(Integer noticeId)
    {
        this.noticeId = noticeId;
    }

    public Integer getNoticeId()
    {
        return noticeId;
    }

    public void setNoticeTitle(String noticeTitle)
    {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle()
    {
        return noticeTitle;
    }

    public void setNoticeType(String noticeType)
    {
        this.noticeType = noticeType;
    }

    public String getNoticeType()
    {
        return noticeType;
    }

    public void setNoticeContent(String noticeContent)
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent()
    {
        return noticeContent;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
}
