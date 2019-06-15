package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.Vacation;

import java.util.List;

@Mapper
public interface VacationDao {
    @Insert("insert into oa_vacation(startdate,days,enddate,processinstanceid,reason,userid,vacationtype)\n" +
            "      values(#{startDate},#{days},#{endDate},#{processInstanceId},#{reason},#{userId},#{vacationType})")
    public void setRecord(Vacation vacation);
    @Select("select * from oa_vacation where userid = #{userId}")
    public List<Vacation> getRecord(String userId);
}
