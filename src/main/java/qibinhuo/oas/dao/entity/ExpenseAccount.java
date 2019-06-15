package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 报销记录实体类
 * @huoqibin 2019/2/7
 *
 */
@Setter
@Getter
@ToString
public class ExpenseAccount {
	private Integer id;
	// 申请人
	private String userId;
	// 报销金额
	private BigDecimal money;
	// 日期
	private String date;
	//流程id
	private String processInstanceId;
}
