package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import qibinhuo.oas.dao.entity.Vacation;

import java.util.List;

/**
 * 请假表单
 * @霍淇滨 2019/2/8
 *
 */
@Setter
@Getter
@ToString
public class VacationForm extends BaseForm {
	private static final long serialVersionUID = 7660661334160737933L;
	// 休假开始日期
	private String startDate;
	// 休假结束日期
	private String endDate;
	// 天数
	private int days;
	//请假类型
	private int vacationType;
	// 原因
	private String reason;
	//用户ID
	private String userId;
	//标题
	private String title;
	//表单类型
	private String businessType;
	//用户姓名
	private String userName;

	public void createFormFields(List<FormField> fields) {
		fields.add(super.getFormField("title", "标题", title));
		fields.add(super.getFormField("userName", "申请用户", userName));
		fields.add(super.getFormField("businessType", "单据类型", businessType));
		fields.add(super.getFormField("startDate", "请假开始日期", startDate));
		fields.add(super.getFormField("endDate", "请假结束日期", endDate));
		fields.add(super.getFormField("days", "休假天数", String.valueOf(days)));
		fields.add(super.getFormField("vacationType", "请假类型", getVacationType(this.vacationType)));
		fields.add(super.getFormField("reason", "原因", reason));
	}

	public String getVacationType(int vacationType) {
		if (Vacation.TYPE_MATTER == vacationType) {
			return "事假";
		} else if (Vacation.TYPE_PAID == vacationType) {
			return "年假";
		} else if (Vacation.TYPE_SICK == vacationType) {
			return "病假";
		}
		return "";
	}
}
