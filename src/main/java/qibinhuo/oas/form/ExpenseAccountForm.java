package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 报销表单对象
 * @霍淇滨  2019/2/8
 *
 */
@Setter
@Getter
@ToString
public class ExpenseAccountForm extends BaseForm {
	private static final long serialVersionUID = 3880815435270982487L;
	// 发生日期
	private String date;
	// 金额
	private String money;
	// 说明
	private String dscp;
	//用户名
	private String userName;

	public void createFormFields(List<FormField> fields) {
		fields.add(super.getFormField("userName", "申请用户", userName));
		fields.add(super.getFormField("date", "费用发生时间", date));
		fields.add(super.getFormField("money", "报销费用 ", money));
		fields.add(super.getFormField("dscp", "描述", dscp));
	}
}
