package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 休假实体类
 * @霍淇滨 2019/2/7
 */
@Setter
@Getter
@ToString
public class Vacation {
	// 年假
	public final static int TYPE_PAID = 0;
	// 事假
	public final static int TYPE_MATTER = 1;
	// 病假
	public final static int TYPE_SICK = 2;

	// 休假的工作日
	private int days;
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	// 休假类型
	private int vacationType;
	//原因
	private String reason;
	// 对应的流程实例id
	private String processInstanceId;
	// 用户id
	private String userId;
}
