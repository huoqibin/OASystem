package qibinhuo.oas.service;

import org.activiti.engine.identity.Group;
import qibinhuo.oas.form.UserForm;
import qibinhuo.oas.vo.UserVO;

import java.util.List;

public interface UserService {
    //查询用户信息
    public UserVO getUserInfo(String userId);
    //添加一个用户
    public void addUser(UserForm userForm);
    //更新用户信息
    public void updateUserInfo(UserForm userForm, String userId);
    //更新密码
    public void modifyPasswd(String passwd, String userId);
    //删除用户
    public void deleteUser(String userId);
    //查询所有用户
    public List<UserVO> queryAllUser();
    //查询所有用户组
    public List<Group> queryAllGroup();
}
