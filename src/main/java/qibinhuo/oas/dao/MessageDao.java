package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.Message;

import java.util.List;

@Mapper
public interface MessageDao {
    //发送消息
    @Insert("insert into oa_message(title,type,sender,date,content,receiver) " +
            "values (#{title},#{type},#{sender},#{date},#{content},#{receiver})")
    public void sendMessage(Message message);

    //发送公告
    @Insert("insert into oa_message(title,type,sender,date,content) " +
            "values (#{title},#{type},#{sender},#{date},#{content})")
    public void sendNotice(Message message);

    //获取消息概况
    @Select("select * from oa_message where receiver=#{id}")
    public List<Message> receiveMessage(String id);

    //获取消息详情
    @Select("select * from oa_message where id=#{messageId}")
    public Message receiveMessageDetail(int messageId);

    //删除消息
    @Delete("delete from oa_message where id=#{message}")
    public void deleteMessage(int messageId);

    //获取公告
    @Select("select * from oa_message where type=3")
    public List<Message> receiveNotice();
}
