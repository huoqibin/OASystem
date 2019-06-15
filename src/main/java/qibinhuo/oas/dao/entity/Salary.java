package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * 薪资实体类
 * @author 霍淇滨 2019/2/7
 *
 */
@Setter
@Getter
@ToString
public class Salary {
	private Integer id;
	// 每月基本工资
	private BigDecimal baseMoney;
	// 用户ID，保存在流程引擎中
	private String userId;
}
