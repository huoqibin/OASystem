package qibinhuo.oas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.SalaryDao;
import qibinhuo.oas.dao.entity.Salary;
import qibinhuo.oas.service.SalaryServcie;

/**
 * 薪资记录Service
 * huoqibin 2019/2/7
 */
@Service
public class SalaryServiceImpl implements SalaryServcie {
    @Autowired
    SalaryDao salaryDao;

    @Override
    public void setRecord(Salary salary) {
        salaryDao.setRecord(salary);
    }

    @Override
    public Salary getRecord(String userId) {
        return salaryDao.getRecord(userId);
    }
}
