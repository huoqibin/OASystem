package qibinhuo.oas.service;

import qibinhuo.oas.dao.entity.Message;

import java.util.List;

public interface MessageService {
    //发送消息
    public boolean sendMessage(Message message);
    //获取消息概况
    public List<Message> receiveMessage(String id);
    //获取消息详情
    public Message receiveMessageDetil(int messageId);
    //删除消息
    public boolean deleteMessage(int messageId);
    //获取公告
    public List<Message> receiveNotice();

}
