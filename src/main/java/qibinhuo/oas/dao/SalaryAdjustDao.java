package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.SalaryAdjust;

import java.util.List;

@Mapper
public interface SalaryAdjustDao {
    @Insert("insert into oa_salary_adjust(adjustmoney,date,dscp,processinstanceid,userid)\n" +
            "      values(#{adjustMoney},#{date},#{dscp},#{processInstanceId},#{userId})")
    public void setRecord(SalaryAdjust salaryAdjust);
    @Select("select * from oa_salary_adjust where userid = #{userId}")
    public List<SalaryAdjust> getRecord(String userId);
}
