package qibinhuo.oas.service;

import qibinhuo.oas.dao.entity.ExpenseAccount;
import qibinhuo.oas.form.ExpenseAccountForm;

import java.util.List;

public interface ExpenseAccountService {
    //添加报销记录
    public void setRecord(ExpenseAccountForm expenseAccountForm, String piId);
    //获取报销记录
    public List<ExpenseAccount> getRecord(String userId);
}
