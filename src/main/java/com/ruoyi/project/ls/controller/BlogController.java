package com.ruoyi.project.ls.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.ls.bean.ActionResultModel;
import com.ruoyi.project.ls.domain.Blog;
import com.ruoyi.project.ls.domain.BlogReply;
import com.ruoyi.project.ls.service.IBlogReplyService;
import com.ruoyi.project.ls.service.IBlogService;
import com.ruoyi.project.system.user.domain.User;

/**
 * 公告 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/pub/notice")
public class BlogController extends BaseController{

	private String prefix = "fly/notice";
	
    @Autowired
    private IBlogService noticeService;
    @Autowired
    private IBlogReplyService noticeReplyService;

    @RequestMapping("/{userName}")
    public String detailList(@PathVariable("userName") String userName, Model model){
    	Blog notice=new Blog();
    	notice.setCreateBy(userName);
    	notice.setStatus("0");
    	List<Blog> list = noticeService.listByCreator(notice);
    	model.addAttribute("userName", userName);
    	model.addAttribute("list", list);
        return prefix + "/pub_notice_list";
    }

    /**
     * 查看公告
     * @param noticeId
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping("/view")
    public String detailView(@RequestParam Integer noticeId,@RequestParam String userName, Model model){
    	Blog notice = noticeService.selectNoticeById(noticeId);
    	noticeService.addViewCount(noticeId);
    	model.addAttribute("notice", notice);
    	model.addAttribute("userName", userName);
        return prefix + "/pub_notice_detail";
    }
    
    /**
     * 添加回复
     * @param noticeId
     * @param replyContent
     * @return
     */
    @ResponseBody
    @RequestMapping("/addReply")
    public AjaxResult addReply(@RequestParam Integer noticeId, String replyContent){
    	noticeService.addReplyCount(noticeId,replyContent);
        return AjaxResult.success("");
    }
    
    /**
     * 获取回复
     * @param noticeId
     * @param replyContent
     * @return
     */
    @ResponseBody
    @RequestMapping("/dataReply")
    public ActionResultModel<BlogReply> dataReply(@RequestParam Integer noticeId){
    	ActionResultModel<BlogReply> arm=new ActionResultModel<BlogReply>();
    	List<BlogReply> list= noticeReplyService.selectNoticeList(noticeId);
    	arm.setSuc(true);
    	arm.setMsg((list==null?0:list.size())+"");
    	arm.setRecords(list);
        return arm;
    }
    
    
    @GetMapping("/flyList")
    public String flyList(Model model){
    	User user=ShiroUtils.getUser();
    	Blog notice=new Blog();
    	notice.setCreateBy(user.getLoginName());
    	List<Blog> list = noticeService.listByCreator(notice);
    	model.addAttribute("userName", user.getLoginName());
    	model.addAttribute("noticeCount", user.getNoticeCount());
    	model.addAttribute("list", list);
        return prefix + "/pub_notice_main";
    }
    
    @GetMapping("/flyAdd")
    public String flyAdd(Model model){
        return prefix + "/pub_notice_add";
    }
    
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @GetMapping("/flyEdit/{noticeId}")
    public String flyEdit(@PathVariable("noticeId") Integer noticeId, Model model){
        Blog notice = noticeService.selectNoticeById(noticeId);
        model.addAttribute("notice", notice);
        return prefix + "/pub_notice_edit";
    }
    
    
    @GetMapping("/flyView")
    public String flyView(@RequestParam Integer noticeId,Model model){
    	Blog notice = noticeService.selectNoticeById(noticeId);
    	model.addAttribute("notice", notice);
        return prefix + "/pub_notice_view";
    }
  
    
    

	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String pubNoticeLogout(@RequestParam("userName") String userName,Model model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/pub/notice/"+userName;
	}
}
