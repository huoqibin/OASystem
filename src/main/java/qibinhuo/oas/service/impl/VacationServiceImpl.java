package qibinhuo.oas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.VacationDao;
import qibinhuo.oas.dao.entity.Vacation;
import qibinhuo.oas.form.VacationForm;
import qibinhuo.oas.service.VacationService;
import qibinhuo.oas.tools.DateUtil;

import java.util.List;

/**
 * 请假记录Service
 * huoqibin 2019/2/7
 */
@Service
public class VacationServiceImpl implements VacationService {
    @Autowired
    VacationDao vacationDao;

    @Override
    public void setRecord(VacationForm vacationForm, String piId) {
        Vacation vacation = new Vacation();
        vacation.setStartDate(vacationForm.getStartDate());
        vacation.setDays(vacationForm.getDays());
        vacation.setEndDate(vacationForm.getEndDate());
        vacation.setProcessInstanceId(piId);
        vacation.setReason(vacationForm.getReason());
        vacation.setUserId(vacationForm.getUserId());
        vacation.setVacationType(vacationForm.getVacationType());
        System.out.println(vacation.toString());
        vacationDao.setRecord(vacation);
    }

    @Override
    public List<Vacation> getRecord(String userId) {
        return vacationDao.getRecord(userId);
    }
}
