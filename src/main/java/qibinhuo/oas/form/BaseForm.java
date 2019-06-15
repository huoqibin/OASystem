package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 表单基类
 * @霍淇滨 2019/2/8
 *
 */
@Setter
@Getter
@ToString
public abstract class BaseForm implements Serializable {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	// 申请日期
	private String requestDate = df.format(new Date());// new Date()为获取当前系统时间
	// 申请人id
	private String userId;
	// 申请的标题
	private String title;
	// 申请人名称
	private String userName;
	// 单据类型
	private String businessType;
	// 表单的域
	private List<FormField> fields = new ArrayList<FormField>();
	// 用于存放FormField对象
	private Map<String, FormField> fileMap = new HashMap<String, FormField>();
	// 请假类型
	public final static String VACATION = "vacation";
	public final static String SALARY = "salary";
	public final static String EXPENSE = "expense";

	// 返回表单属性和值
	public List<FormField> getFormFields() {
		fields.add(getFormField("requestDate", "申请时间", requestDate));
		createFormFields(fields);
		fields.add(getFormField("title", "标题", title));
		//fields.add(getFormField("userName", "申请用户", userName));
		fields.add(getFormField("businessType", "单据类型", businessType));
		return fields;
	}

	protected FormField getFormField(String key, String text, String value) {
		if (fileMap.get(key) == null) {
			FormField field = new FormField(text, value);
			fileMap.put(key, field);
		}
		return fileMap.get(key);
	}

	// 由子类设置表单属性
	public abstract void createFormFields(List<FormField> fields);


}
