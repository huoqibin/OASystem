package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 薪资调整实体类
 * @huoqibin 2019/2/7
 */
@Setter
@Getter
@ToString
public class SalaryAdjust {
	private Integer id;
	// 用户id
	private String userId;
	//调整金额
	private BigDecimal adjustMoney;
	// 日期
	private String date;
	// 描述
	private String dscp;
	// 流程实例id
	private String processInstanceId;
}
