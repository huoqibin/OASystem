package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.Salary;

@Mapper
public interface SalaryDao {
    @Insert("insert into oa_salary(basemoney,userid) values(#{baseMoney},#{userId})")
    public void setRecord(Salary salary);
    @Select("select * from oa_salary where userid = #{userId}")
    public Salary getRecord(String userId);
}
