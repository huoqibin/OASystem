package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class StampForm extends BaseForm{
    private String userId;
    private String userName;
    private String date;
    private String reason;

    @Override
    public void createFormFields(List<FormField> fields) {
        fields.add(super.getFormField("userName", "申请用户", userName));
        fields.add(super.getFormField("date", "用印时间", date));
        fields.add(super.getFormField("reason", "原因", reason));
    }
}
