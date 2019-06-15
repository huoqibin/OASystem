package qibinhuo.oas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 流程值对象
 * @霍淇滨 2019/2/8
 *
 */
@Setter
@Getter
@ToString
public class ProcessVO {
	// 流程实例id
	private String id;
	// 申请标题
	private String title;
	// 申请日期
	private String requestDate;
}
