package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserForm {
    //用户ID
    private String userId;
    // 用户真实姓名
    private String lastName;
    // 密码
    private String passwd;
    // 用户组id
    private String groupId;
    //用户组名
    private String groupName;
    // 年龄
    private int age;
    //用户邮箱
    private String email;
    //职位
    private String position;
}
