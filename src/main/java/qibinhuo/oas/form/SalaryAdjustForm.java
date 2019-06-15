package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 薪资调整表单
 * @霍淇滨 2019/2/8
 */
@Setter
@Getter
@ToString
public class SalaryAdjustForm extends BaseForm {
	private static final long serialVersionUID = -6561226199382098070L;
	// 薪资调整的员工
	private String lastName;
	// 薪资调整员工id
	private String userId;
	// 调整金额
	private String money;
	// 描述
	private String dscp;
	//用户名
	private String userName;

	public void createFormFields(List<FormField> fields) {
		fields.add(super.getFormField("employeeName", "申请用户", lastName));
		fields.add(super.getFormField("money", "调薪金额", money));
		fields.add(super.getFormField("dscp", "描述", dscp));
	}

}
