package qibinhuo.oas.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import qibinhuo.oas.dao.entity.Files;
import qibinhuo.oas.form.Pages;

import java.util.List;

public interface FileService {
    //获取公司文件总数
    public int companyFileNum();

    //获取小组文件总数，某个小组
    public int groupFileNum(String groupId);

    //获取小组文件总数，全部小组
    public int groupAllFileNum();

    //获取公司文件列表，第几页
    public List<Files> componyFileList(Pages pages);

    //获取小组文件列表，某个小组，第几页
    public List<Files> groupFileList(String groupId, Pages pages);

    //获取小组文件列表，全部小组，第几页
    public List<Files> groupAllFileList(Pages pages);

    //根据文件类型查找文件,某个小组
    public List<Files> getGroupFileByClass(String groupId,String fileClass);

    //根据文件类型查找文件,全部小组
    public List<Files> getGroupAllFileByClass(String fileClass);

    //根据文件类型查找文件,公司文件
    public List<Files> getCompanyFileByClass(String fileClass);

    //根据关键字查找文件,某个小组文件
    public List<Files> getGroupFileByKey(String groupId, String fileKey);

    //根据关键字查找文件,全部小组文件
    public List<Files> getGroupAllFileByKey(String fileKey);

    //根据关键字查找文件,公司文件
    public List<Files> getCompanyFileByKey(String fileKey);

    //根据关键字和类型查询公司文件
    public List<Files> getCompanyFileByClassAndKey(String fileClass,String fileKey);

    //根据关键字和类型查询某个小组文件
    public List<Files> getGroupFileByClassAndKey(String group,String fileClass,String fileKey);

    //根据关键字和类型查询全部小组文件
    public List<Files> getGroupAllFileByClassAndKey(String fileClass,String fileKey);

    //上传小组文件到数据库
    public void addGroupFile(Files files);

    //上传公司文件到数据库
    public void addCompanyFile(Files files);

    //获取文件src(用于下载文件)
    public String getFileSrc(String fileRealName);

    //获取文件上传者
    public String getFileUploader(String fileRealName);

    //删除文件
    public void deleteFile(String fileRealName);
}
