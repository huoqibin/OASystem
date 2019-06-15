package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.ExpenseAccount;

import java.util.List;

@Mapper
public interface ExpenseAccountDao {
    @Insert("insert into oa_expense_account(date,money,processinstanceid,userid) values(#{date},#{money},#{processInstanceId},#{userId})")
    public void setRecord(ExpenseAccount expenseAccount);
    @Select("select * from oa_expense_account where userid = #{userId}")
    public List<ExpenseAccount> getRecord(String userId);
}
