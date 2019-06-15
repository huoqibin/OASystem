package qibinhuo.oas.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.form.UserForm;
import qibinhuo.oas.service.UserService;
import qibinhuo.oas.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private IdentityService identityService;

    /**
     * 获取用户信息Service
     * @param userId
     * @return
     */
    @Override
    public UserVO getUserInfo(String userId) {
        logger.info("调用getUserInfo方法获取用户信息");

        User user = identityService.createUserQuery().userId(userId).singleResult();
        if(user == null){
            return new UserVO();
        }
        Group group = identityService.createGroupQuery().groupMember(user.getId()).singleResult();
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getId());     //用户Id
        userVO.setLastName(user.getLastName());    //真实姓名
        userVO.setEmail(user.getEmail());    //邮箱
        userVO.setGroupId(group.getId());    //用户组ID
        userVO.setGroupName(group.getName());    //所属用户组Name
        userVO.setAge(Integer.parseInt(identityService.getUserInfo(user.getId(), "age")));    //年龄
        userVO.setPosition(identityService.getUserInfo(user.getId(), "position"));    //职位

        return userVO;
    }

    /**
     * 添加用户Service（管理员功能）
     * @param userForm
     */
    @Override
    public void addUser(UserForm userForm) {
        logger.info("调用addUser方法添加用户");
        //1 生成一个唯一的用户id并新建用户
        String random = RandomStringUtils.random(4, false, true);
        String userId = userForm.getLastName()+random;
        logger.info("生成的唯一用户id:"+userId);
        User user = identityService.newUser(userId);
        //2 设置用户信息并保存用户
        user.setLastName(userForm.getLastName());    //真实姓名
        user.setPassword(userForm.getPasswd());    //登陆密码
        user.setEmail(userForm.getEmail());     //设置邮箱
        identityService.saveUser(user);
        //3 为用户设置额外信息
        identityService.setUserInfo(user.getId(), "age", String.valueOf(userForm.getAge()));    //年龄信息
        identityService.setUserInfo(user.getId(),"position", userForm.getPosition());    //用户邮箱
        //4 设置与用户组的关系
        identityService.createMembership(user.getId(), userForm.getGroupId());
    }

    /**
     * 更新用户信息Service
     * @param userForm
     */
    @Override
    public void updateUserInfo(UserForm userForm, String userId) {
        logger.info("调用updateUserInfo方法更新用户信息，更新表单数据："+userForm);
        //1 查询用户
        User user = identityService.createUserQuery().userId(userId).singleResult();
        //1.2 更新邮箱
        String email = userForm.getEmail();
        if(email == null || "".equals(email)){}
        else user.setEmail(email);
        //1.3 更新年龄
        int age = userForm.getAge();
        if(age != 0)  identityService.setUserInfo(user.getId(), "age", String.valueOf(age));
        //1.4 更新职位
        String position = userForm.getPosition();
        if(position == null || "".equals(position)) {}
        else identityService.setUserInfo(user.getId(),"position",position);
        //1.5 更新用户组
        String groupId = userForm.getGroupId();
        if(groupId == null || "".equals(groupId)){}
        else{
            //获取原绑定的用户组
            Group group = identityService.createGroupQuery().groupMember(user.getId()).singleResult();
            //解绑原关系
            identityService.deleteMembership(user.getId(),group.getId());
            //绑定新关系
            identityService.createMembership(user.getId(),userForm.getGroupId());
        }
        identityService.saveUser(user);
    }

    /**
     * 更新密码
     * @param passwd
     * @param userId
     */
    @Override
    public void modifyPasswd(String passwd, String userId) {
        logger.info("调用modifyPasswd更新用户密码");
        //1 查询用户
        User user = identityService.createUserQuery().userId(userId).singleResult();
        user.setPassword(passwd);
        identityService.saveUser(user);
    }

    /**
     * 查询所有用户Service
     * @return
     */
    @Override
    public List<UserVO> queryAllUser() {
        logger.info("调用queryAllUser方法查询所有用户");
        //获取所有user
        List<User> users = identityService.createUserQuery().list();
        List<UserVO> result = new ArrayList<UserVO>();
        //将数据转成UserVO
        for (User user : users) {
            UserVO userVO = new UserVO();
            userVO.setUserId(user.getId());
            userVO.setEmail(user.getEmail());
            userVO.setLastName(user.getLastName());
            // 查询用户组
            Group group = identityService.createGroupQuery()
                    .groupMember(user.getId()).singleResult();
            // 查询附加信息
            userVO.setGroupName(group.getName());
            userVO.setGroupId(group.getId());
            userVO.setAge(Integer.parseInt(identityService.getUserInfo(user.getId(), "age")));
            userVO.setPosition(identityService.getUserInfo(user.getId(), "position"));    //职位
            result.add(userVO);
        }
        return result;
    }

    /**
     * 删除用户Service
     * @param userId
     */
    @Override
    public void deleteUser(String userId) {
        logger.info("调用deleteUser方法删除用户");
        identityService.deleteUser(userId);
    }

    /**
     * 获取所有用户组Service
     * @return
     */
    @Override
    public List<Group> queryAllGroup() {
        logger.info("调用queryAllGroup查询所有用户组");
        return identityService.createGroupQuery().list();

    }
}
