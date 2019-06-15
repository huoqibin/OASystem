package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.Salary;
import qibinhuo.oas.dao.entity.Stamp;

import java.util.List;

@Mapper
public interface StampDao {
    @Insert("insert into oa_stamp(userid,processinstanceid,date,reason) " +
            "values(#{userId},#{processInstanceId},#{date},#{reason})")
    public void setRecord(Stamp stamp);
    @Select("select * from oa_stamp where userid = #{userId}")
    public List<Stamp> getRecord(String userId);
}
