package qibinhuo.oas.service;

import qibinhuo.oas.dao.entity.Salary;

public interface SalaryServcie {
    //添加薪资记录
    public void setRecord(Salary salary);
    //获取薪资记录
    public Salary getRecord(String userId);
}
