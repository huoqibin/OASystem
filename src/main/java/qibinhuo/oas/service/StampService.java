package qibinhuo.oas.service;

import qibinhuo.oas.dao.entity.Stamp;
import qibinhuo.oas.form.StampForm;

import java.util.List;

public interface StampService {
    //添加用印记录
    public void setRecord(StampForm stampForm, String piId);
    //获取用印记录
    public List<Stamp> getRecord(String userId);
}
