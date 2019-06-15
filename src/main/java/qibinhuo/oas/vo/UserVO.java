package qibinhuo.oas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户值对象
 * @霍淇滨 2019/2/8
 */
@Setter
@Getter
@ToString
public class UserVO {
	//用户Id
	private String userId;
	// 用户真实姓名
	private String lastName;
	// 密码
	private String passwd;
	// 用户组id
	private String groupId;
	//用户组名称
	private String groupName;
	//年龄
	private int age;
	//用户邮箱
	private String email;
	//职位
	private String position;
}
