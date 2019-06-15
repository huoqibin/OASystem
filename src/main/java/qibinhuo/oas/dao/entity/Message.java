package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Message {
    private int id;    //id
    private String title;    //消息标题
    private int type;    //消息类型 0:系统消息 1：个人消息 2：小组消息  3：公告
    private String sender;    //发送方
    private String date;    //发送时间
    private String content;    //消息内容
    private String receiver;    //接受方
}
