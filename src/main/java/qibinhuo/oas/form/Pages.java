package qibinhuo.oas.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Pages {
    private int fullLine;  //总行数
    private int fullPage;  //总页数
    private int startLine;  //开始行数
    private int startPage;    //开始页数
    private static final int pageSize = 20;  //每页记录数
}
