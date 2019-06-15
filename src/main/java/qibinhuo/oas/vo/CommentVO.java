package qibinhuo.oas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 任务评论值对象
 * @霍淇滨 2018/2/8
 */
@Setter
@Getter
@ToString
public class CommentVO implements Serializable {
	// 评论人
	private String userName;
	// 评论内容
	private String content;
	// 评论时间
	private String time;
}
