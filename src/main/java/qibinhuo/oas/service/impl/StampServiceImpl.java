package qibinhuo.oas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.StampDao;
import qibinhuo.oas.dao.entity.Stamp;
import qibinhuo.oas.form.StampForm;
import qibinhuo.oas.service.StampService;

import java.util.List;

@Service
public class StampServiceImpl implements StampService {
    @Autowired
    private StampDao stampDao;
    @Override
    public void setRecord(StampForm stampForm, String piId) {
        Stamp stamp = new Stamp();
        stamp.setUserId(stampForm.getUserId());
        stamp.setDate(stampForm.getDate());
        stamp.setProcessInstanceId(piId);
        stamp.setReason(stampForm.getReason());
        stampDao.setRecord(stamp);
    }

    @Override
    public List<Stamp> getRecord(String userId) {
        return stampDao.getRecord(userId);
    }
}
