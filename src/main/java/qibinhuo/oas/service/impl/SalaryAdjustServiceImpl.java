package qibinhuo.oas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.SalaryAdjustDao;
import qibinhuo.oas.dao.entity.SalaryAdjust;
import qibinhuo.oas.form.SalaryAdjustForm;
import qibinhuo.oas.service.SalaryAdjustService;
import qibinhuo.oas.tools.DateUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * 薪资调整Service
 * huoqibin 2019/2/7
 */
@Service
public class SalaryAdjustServiceImpl implements SalaryAdjustService {
    @Autowired
    SalaryAdjustDao salayAdjustDao;

    @Override
    public void setRecord(SalaryAdjustForm salaryAdjustForm, String piId, String userId) {
        SalaryAdjust salaryAdjust = new SalaryAdjust();
        salaryAdjust.setAdjustMoney(new BigDecimal(salaryAdjustForm.getMoney()));
        String date= DateUtil.getDateString(new Date());
        System.out.println(date);
        salaryAdjust.setDate(date);
        salaryAdjust.setDscp(salaryAdjustForm.getDscp());
        salaryAdjust.setUserId(userId);
        salaryAdjust.setProcessInstanceId(piId);
        salayAdjustDao.setRecord(salaryAdjust);
    }

    @Override
    public List<SalaryAdjust> getRecord(String userId) {
        return salayAdjustDao.getRecord(userId);
    }
}
