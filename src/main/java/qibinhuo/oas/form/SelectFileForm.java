package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SelectFileForm {
    private int type;    //0：公司文件，1：小组文件
    private String keyWord;    //关键字
    private String fileClass;    //文件类别
    private String groupId;    //小组Id
}
