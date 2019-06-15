package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PDForm {
    private String oldpasswd;
    private String passwd;
    private String newpasswd;
}
