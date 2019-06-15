package qibinhuo.oas.service;

import qibinhuo.oas.dao.entity.SalaryAdjust;
import qibinhuo.oas.form.SalaryAdjustForm;

import java.util.List;

public interface SalaryAdjustService {
    //添加薪资调整记录
    public void setRecord(SalaryAdjustForm salaryAdjustForm, String piId, String userId);
    //获取薪资调整记录
    public List<SalaryAdjust> getRecord(String userId);
}
