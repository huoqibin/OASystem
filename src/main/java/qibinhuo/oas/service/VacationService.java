package qibinhuo.oas.service;

import qibinhuo.oas.dao.entity.Vacation;
import qibinhuo.oas.form.VacationForm;

import java.util.List;

public interface VacationService {
    //添加请假记录
    public void setRecord(VacationForm vacationForm, String piId);
    //获取请假记录
    public List<Vacation> getRecord(String userId);
}
