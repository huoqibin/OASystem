package qibinhuo.oas.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Files {
    private int fileId;    //文件id
    private String fileRealName;    //文件真实名
    private String fileShowName;    //文件展示名
    private String fileUploader;    //文件上传者
    private String fileGroup;    //文件分组
    private String fileCreatetime;    //文件创建时间
    private String fileSrc;    //文件保存位置
    private String fileClass;    //文件分类
}
