package qibinhuo.oas.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.MessageDao;
import qibinhuo.oas.dao.entity.Message;
import qibinhuo.oas.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    @Autowired
    private MessageDao messageDao;

    /**
     * 发送消息/公告
     * @param message
     * @return
     */
    @Override
    public boolean sendMessage(Message message) {
        int type = message.getType();
        if(type == 0 || type == 1 || type == 2) {
            messageDao.sendMessage(message);
        }else{
            messageDao.sendNotice(message);
        }
        return true;
    }

    /**
     * 接收消息概况
     * @param userId
     * @return
     */
    @Override
    public List<Message> receiveMessage(String userId) {
        return messageDao.receiveMessage(userId);
    }

    /**
     * 接收消息详情
     * @param messageId
     * @return
     */
    @Override
    public Message receiveMessageDetil(int messageId) {
        return messageDao.receiveMessageDetail(messageId);
    }

    /**
     * 删除消息
     * @param messageId
     * @return
     */
    @Override
    public boolean deleteMessage(int messageId) {
        messageDao.deleteMessage(messageId);
        return true;
    }

    /**
     * 接收公告
     * @return
     */
    @Override
    public List<Message> receiveNotice() {
        return messageDao.receiveNotice();
    }
}
