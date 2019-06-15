package qibinhuo.oas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 历史记录值对象
 * @huoqibin 2019/2/8
 */
@Setter
@Getter
@ToString
public class MyListVO {
	// 请假天数
	private int days;
	// 请假原因
	private String reason;
	// 申请日期
	private String date;
}
