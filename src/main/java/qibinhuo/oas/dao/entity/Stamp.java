package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Stamp {
    private Integer id;
    // 用户id
    private String userId;
    // 流程实例id
    private String processInstanceId;
    //日期
    private String date;
    //原因
    private String reason;
}
