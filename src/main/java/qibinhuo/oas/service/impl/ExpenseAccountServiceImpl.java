package qibinhuo.oas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.ExpenseAccountDao;
import qibinhuo.oas.dao.entity.ExpenseAccount;
import qibinhuo.oas.form.ExpenseAccountForm;
import qibinhuo.oas.service.ExpenseAccountService;
import qibinhuo.oas.tools.DateUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * 报销记录Service 2019/2/7
 */
@Service
public class ExpenseAccountServiceImpl implements ExpenseAccountService{
    @Autowired
    ExpenseAccountDao expenseAccountDao;

    @Override
    public void setRecord(ExpenseAccountForm expenseAccountForm,String piId) {
        ExpenseAccount expenseAccount = new ExpenseAccount();
        expenseAccount.setDate((DateUtil.getDateString(new Date())));
        expenseAccount.setMoney(new BigDecimal(expenseAccountForm.getMoney()));
        expenseAccount.setProcessInstanceId(piId);
        expenseAccount.setUserId(expenseAccountForm.getUserId());
        expenseAccountDao.setRecord(expenseAccount);
    }

    @Override
    public List<ExpenseAccount> getRecord(String userId) {
        return expenseAccountDao.getRecord(userId);
    }
}