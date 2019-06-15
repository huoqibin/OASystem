package qibinhuo.oas.form;

import lombok.*;

import java.io.Serializable;

/**
 * @霍淇滨 2019/2/10
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FormField implements Serializable {
	// 表单域的文本
	private String filedText;
	// 表单域的值
	private String fieldValue;
}
