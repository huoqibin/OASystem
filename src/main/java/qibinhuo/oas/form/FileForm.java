package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FileForm {
    private String userId;
    private String groupId;
    private int type;
    private String fileClass;
}
