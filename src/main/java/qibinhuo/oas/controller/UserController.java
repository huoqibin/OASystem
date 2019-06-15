package qibinhuo.oas.controller;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qibinhuo.oas.form.PDForm;
import qibinhuo.oas.form.UserForm;
import qibinhuo.oas.service.UserService;
import qibinhuo.oas.tools.MD5;
import qibinhuo.oas.vo.UserVO;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;

/**
 * 用来处理用户相关请求
 */
@Controller
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IdentityService identityService;
    @Autowired
    private UserService userService;

    /**
     * 初始跳转登录页面
     * @return
     */
    @RequestMapping("/")
    public String index(){
        logger.info("进入系统，跳转登陆页面");
        return "login";
    }

    /**
     * 登录功能  2019/1/26
     * @param userId 用户id
     * @param passwd  用户密码
     * @param session  用来保存用户登录信息
     * @return  返回页面
     */
    @RequestMapping("/main")
    public String login(String userId, String passwd, HttpSession session) throws Exception {
        logger.info("用户登录，调用登录方法");
        String pwd = MD5.encrypt_MD5(passwd);
        boolean tof = identityService.checkPassword(userId,pwd);
        if(tof){
            //将用户信息写入Session
            User user = identityService.createUserQuery().userId(userId).singleResult();
            session.setAttribute("user",user);
            UserVO userVO = userService.getUserInfo(userId);
            session.setAttribute("userVO",userVO);
            logger.info("登陆成功，将用户信息写入session，跳转main主页面");
            return "main";
        }else{
            logger.warn("登录失败，返回登陆页面");
            return "login";
        }
    }

    /**
     * 登出功能
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        logger.info("用户登出，调用登出方法");
        session.removeAttribute("user");
        session.removeAttribute("userVO");
        return "login";
    }

    /**
     * 查询用户信息
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/getuserinfo")
    public String getUserInfo(HttpSession session, Model model){
        logger.info("进入查询用户信息方法");
        //获取用户id
        User user = (User)session.getAttribute("user");
        //调用userService获取用户信息
        UserVO result = userService.getUserInfo(user.getId());
        logger.info("查询到的用户信息："+result.toString());
        model.addAttribute("user",result);
        logger.info("查询用户信息结束，返回用户信息详情页面");
        return "user/userinfo";
    }

    /**
     * 添加用户
     * @param userForm
     * @return
     */
    @RequestMapping("/adduser")
    public String addUser(UserForm userForm,Model model){
        logger.info("添加用户方法开始,待添加用户："+userForm.toString());
        userService.addUser(userForm);
        model.addAttribute("message","添加用户成功！");
        logger.info("添加用户方法结束，返回信息");
        return "message";
    }


    /**
     * 用户更新信息
     * @param userForm
     * @return
     */
    @RequestMapping("/updateuserinfo")
    public String updateUserInfo(UserForm userForm, Model model, HttpSession session){
        logger.info("更新用户信息方法开始，待更新用户数据："+userForm.toString());
        //获取用户id
        User user = (User)session.getAttribute("user");
        userService.updateUserInfo(userForm, user.getId());
        model.addAttribute("message","更新信息成功！");
        logger.info("更新用户信息结束,返回信息");
        return "message";
    }

    /**
     * 管理员更新用户公司信息
     * @param userForm
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/managerupdate")
    public String managerUpdate(UserForm userForm,Model model,HttpSession session){
        logger.info("管理员更新用户公司信息："+userForm);
        userService.updateUserInfo(userForm,userForm.getUserId());
        model.addAttribute("message","更新员工信息成功！");
        logger.info("管理员更新员工信息成功！");
        return "message";
    }

    /**
     * 更新用户密码
     * @param pdForm
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/modifypasswd")
    public String modifyPasswd(PDForm pdForm, Model model, HttpSession session) throws Exception {
        String oldpasswd = MD5.encrypt_MD5(pdForm.getOldpasswd());
        String passwd = pdForm.getPasswd();
        String newpasswd = pdForm.getNewpasswd();
        logger.info("更新密码方法开始，旧密码："+oldpasswd+",新密码："+passwd+"二次输入新密码："+newpasswd);
        //获取用户id
        User user = (User)session.getAttribute("user");
        //验证旧密码是否正确
        if(!user.getPassword().equals(oldpasswd)){
            model.addAttribute("message","原密码输入错误！");
        }else if(!passwd.equals(newpasswd)){
            model.addAttribute("message","两次新密码输入不一致！");
        } else{
            String pwd = MD5.encrypt_MD5(passwd);
            //更新密码
            userService.modifyPasswd(pwd, user.getId());
            logger.info("更新密码结束，返回信息");
            model.addAttribute("message","更新密码成功！");
        }

        return "message";
    }

    /**
     * 重置密码
     * @param userId
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/resetpasswd/{userId}")
    public String resetPasswd(@PathVariable String userId, Model model, HttpSession session) throws Exception {
        logger.info("重置密码方法开始，重置用户为："+userId);
        User user = identityService.createUserQuery().userId(userId).singleResult();
        if(user == null){
            logger.warn("用户不存在！");
            model.addAttribute("message","用户不存在！");
        }
        String pwd = MD5.encrypt_MD5("123456");
        userService.modifyPasswd(pwd,userId);
        logger.info("重置"+userId+"密码成功！");
        model.addAttribute("message","重置密码成功！");
        return "message";
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/deleteuser/{userId}")
    public String deleteUser(@PathVariable String userId,Model model){
        logger.info("删除用户方法开始，待删除用户id:"+userId);
        userService.deleteUser(userId);
        model.addAttribute("message","删除"+userId+"成功！");
        logger.info("删除用户方法结束，返回信息");
        return "message";
    }

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping(value={"/queryalluser"})
    public String queryAllUser(Model model){
        logger.info("查询所有用户方法开始");
        //调用userService获取用户信息
        List<UserVO> result = userService.queryAllUser();
        model.addAttribute("users",result);
        logger.info("查询所有用户方法结束，返回用户列表页面");
        return "user/user";
    }

    /**
     * 获取通讯录
     * @param model
     * @return
     */
    @RequestMapping(value={"/getbook"})
    public String getBook(Model model){
        logger.info("查询通讯录开始");
        //调用userService获取用户信息
        List<UserVO> result = userService.queryAllUser();
        model.addAttribute("users",result);
        logger.info("查询通讯录结束，返回用户列表页面");
        return "message/sendmessage";
    }

    /**
     * 查询所有用户组
     * @param model
     * @return
     */
    @RequestMapping("/queryallgroup")
    public String queryAllGroup(Model model){
        logger.info("查询所有用户组方法开始");
        List<Group> result = userService.queryAllGroup();
        for(Group group: result)
        System.out.println(group.toString());
        model.addAttribute("groups",result);
        logger.info("查询所有用户组方法结束，返回用户组页面");
        return "user/group";
    }

    /**
     * 添加用户时查询用户组列表
     * @param model
     * @return
     */
    @RequestMapping("/querygrouplist")
    public String queryGroupList(Model model){
        logger.info("添加用户时查询用户组列表方法开始");
        List<Group> result = userService.queryAllGroup();
        model.addAttribute("groups",result);
        logger.info("添加用户时查询用户组列表结束，返回添加用户页面");
        return "user/adduser";
    }
}
