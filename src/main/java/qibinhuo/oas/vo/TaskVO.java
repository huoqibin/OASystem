package qibinhuo.oas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 任务值对象
 * @霍淇滨 2019/2/8
 */
@Setter
@Getter
@ToString
public class TaskVO {
	// 待办任务标识
	public final static String CANDIDATE = "candidate";
	
	// 受理任务标识
	public final static String ASSIGNEE = "assignee";

	// 标题
	private String title;
	
	// 请求用户名称
	private String requestUser;
	
	// 请求日期
	private String requestDate;
	
	//流程实例id
	private String processInstanceId;
	
	// 任务id
	private String taskId;
}
