package qibinhuo.oas.controller;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qibinhuo.oas.dao.entity.Message;
import qibinhuo.oas.service.MessageService;
import qibinhuo.oas.service.UserService;
import qibinhuo.oas.tools.DateUtil;
import qibinhuo.oas.vo.UserVO;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {
    private final static Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private  IdentityService identityService;

    /**
     * 发送消息/公告Controller
     * @param message
     * @param model
     * @return
     */
    @RequestMapping("/sendmessage")
    public String sendMessage(Message message, Model model){
        logger.info("发送消息方法开始，当前消息内容："+message.toString());
        //判断接收人是否存在
        String receiver = message.getReceiver();
        System.out.println("接收人："+receiver);
        if(receiver.indexOf("Group")>0){    //接收方是用户组
            //1  获取用户组所有用户
            List<User> users = identityService.createUserQuery().memberOfGroup(receiver).list();
            //2  对每个用户包装一个Message对象
            for(User user: users){
                System.out.println(user.getId());
                Message messageL = new Message();
                messageL.setSender(message.getSender());
                messageL.setReceiver(user.getId());
                messageL.setType(message.getType());
                messageL.setTitle(message.getTitle());
                messageL.setContent(message.getContent());
                messageL.setDate(DateUtil.getDateString(new Date()));
                //3  调用消息服务发送消息
                System.out.println(messageL.toString());
                messageService.sendMessage(messageL);
            }

            model.addAttribute("message","发送小组消息成功！");
            logger.info("发送小组消息成功！");
        }else{
            UserVO userVO = userService.getUserInfo(receiver);
            if(message.getType()!=3 && (userVO.getUserId() == null || userVO.getUserId().equals(""))){
                model.addAttribute("message","查询不到联系人！");
                logger.warn("接收方不存在！");
            }else{
                //获取当前时间
                message.setDate(DateUtil.getDateString(new Date()));
                boolean tof = messageService.sendMessage(message);
                if(tof) model.addAttribute("message","发送成功");
                else model.addAttribute("message","发送失败");

                logger.info("发送消息方法结束，返回信息");
            }
        }

        return "message";
    }

    /**
     * 接收到的消息列表
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/receivemessage")
    public String receiveMessage(Model model, HttpSession session){
        logger.info("获取消息概况方法开始");

        User user = (User)session.getAttribute("user");
        UserVO userVO = (UserVO)session.getAttribute("userVO");
        List<Message> messageList = messageService.receiveMessage(user.getId());
        List<Message> messageList_g = messageService.receiveMessage(userVO.getGroupId());
        messageList.addAll(messageList_g);
        model.addAttribute("messagelist",messageList);

        logger.info("获取消息概况方法结束，返回消息列表页面");
        return "message/messagelist";
    }

    /**
     * 获取消息详情
     * @param messageId
     * @param model
     * @return
     */
    @RequestMapping("/receivemessagedetail/{messageId}")
    public String receiveMessageDetail(@PathVariable int messageId, Model model){
        logger.info("获取消息详情方法开始");
        Message message = messageService.receiveMessageDetil(messageId);
        logger.info("当前消息详情："+message.toString());
        model.addAttribute("message",message);

        logger.info("获取消息详情方法结束，返回消息详情页面");
        return "message/messagedetail";
    }

    /**
     * 删除消息
     * @param messageId
     * @param model
     * @return
     */
    @RequestMapping("/deletemessage/{messageId}")
    public String deleteMessage(@PathVariable int messageId,Model model){
        logger.info("删除消息方法开始，待删除消息id:"+messageId);
        messageService.deleteMessage(messageId);
        model.addAttribute("message","成功删除消息！");
        logger.info("删除消息方法结束，返回信息");
        return "message";
    }

    /**
     * 获取公告
     * @param model
     * @return
     */
    @RequestMapping("/receivenotice")
    public String receiveNotice(Model model){
        logger.info("获取公告方法开始");
        List<Message> messageList = messageService.receiveNotice();
        model.addAttribute("noticelist",messageList);
        logger.info("获取公告方法结束");
        return "message/notice";
    }

    /**
     * 获取公告列表
     * @param model
     * @return
     */
    @RequestMapping("/noticemag")
    public String noticeMag(Model model){
        logger.info("管理员功能，获取公告列表方法开始");
        List<Message> messageList = messageService.receiveNotice();
        model.addAttribute("noticelist",messageList);
        logger.info("获取公告列表方法结束，返回公告列表");
        return "message/noticemag";
    }

    /**
     * 删除公告
     * @param noticeId
     * @param model
     * @return
     */
    @RequestMapping("/deletenotice/{noticeId}")
    public String deleteNotice(@PathVariable int noticeId,Model model){
        logger.info("管理员功能，删除公告方法开始，待删除公告id:"+noticeId);
        messageService.deleteMessage(noticeId);
        model.addAttribute("message","删除公告成功！");
        logger.info("删除公告方法结束，返回信息");
        return "message";
    }
}
