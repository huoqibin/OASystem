package qibinhuo.oas.dao;

import org.apache.ibatis.annotations.*;
import qibinhuo.oas.dao.entity.Files;

import java.util.List;

@Mapper
public interface FilesDao {
    //获取公司文件总数--普通员工和管理员都可使用
    @Select("select count(*) from oa_file where filegroup is null;")
    public int companyFileNum();

    //获取小组文件总数，某个小组--普通员工使用
    @Select("select count(*) from oa_file where filegroup=#{groupId};")
    public int groupFileNum(String groupId);

    //获取公司文件列表，从第几个到第几个--普通员工和管理员都可使用
    @Select("select * from oa_file where filegroup is null order by fileid limit #{page},#{count};")
    public List<Files> componyFileList(@Param("page")int page, @Param("count")int count);

    //获取小组文件列表，某个小组，从第几个到第几个--普通员工使用
    @Select("select * from oa_file where filegroup=#{groupId} order by fileid limit #{page},#{count};")
    public List<Files> groupFileList(@Param("groupId")String groupId,@Param("page")int page, @Param("count")int count);

    //根据文件类型查找文件,公司文件--普通员工和管理员都可使用
    @Select("select * from oa_file where fileclass=#{fileClass} and filegroup is null;")
    public List<Files> getCompanyFileByClass(String fileClass);

    //根据关键字查找文件,公司文件--根据关键字查找公式文件
    @Select("select * from oa_file where filegroup is null and fileshowname like #{fileKey}")
    public List<Files> getCompanyFileByKey(String fileKey);

    //根据文件类型查找文件,某个小组--普通员工使用
    @Select("select * from oa_file where fileclass=#{fileClass} and filegroup=#{groupId};")
    public List<Files> getGroupFileByClass(@Param("groupId")String groupId,@Param("fileClass")String fileClass);

    //根据关键字查找文件,某个小组--普通员工使用
    @Select("select * from oa_file where filegroup=#{groupId} and fileshowname like #{fileKey}")
    public List<Files> getGroupFileByKey(@Param("groupId")String groupId, @Param("fileKey")String fileKey);

    //根据文件分类和关键字查找公司文件--普通员工和管理员皆可使用
    @Select("select * from oa_file where filegroup is null and fileclass=#{fileClass} and fileshowname like #{fileKey}")
    public List<Files> getCompanyFileByClassAndKey(@Param("fileClass")String fileClass,@Param("fileKey")String fileKey);
    //根据文件分类和关键字查找某个小组文件--普通员工使用
    @Select("select * from oa_file where filegroup is not null and filegroup=#{groupId} and fileclass=#{fileClass} and fileshowname like #{fileKey};")
    public List<Files> getGroupFileByClassAndKey(@Param("groupId")String groupId,@Param("fileClass")String fileClass,@Param("fileKey")String fileKey);

    //上传小组文件到数据库
    @Insert("insert into oa_file(filerealname,fileshowname,fileuploader,filegroup,fileclass,filecreatetime,filesrc) " +
            "values(#{fileRealName},#{fileShowName},#{fileUploader},#{fileGroup},#{fileClass},#{fileCreatetime},#{fileSrc});")
    public void addGroupFile(Files files);

    //上传公司文件到数据库
    @Insert("insert into oa_file(filerealname,fileshowname,fileuploader,fileclass,filecreatetime,filesrc) " +
            "values(#{fileRealName},#{fileShowName},#{fileUploader},#{fileClass},#{fileCreatetime},#{fileSrc});")
    public void addCompanyFile(Files files);

    //获取文件上传者(用于删除文件验证)
    @Select("select fileuploader from oa_file where filerealname=#{fileRealName};")
    public String getFileUploader(String fileRealName);

    //获取文件src(用于下载文件)
    @Select("select filesrc from oa_file where filerealname=#{fileRealName};")
    public String getFileSrc(String fileRealName);

    //删除文件
    @Delete("delete from oa_file where filerealname=#{fileRealName};")
    public void deleteFile(String fileRealName);

    /*****************************管理员专属************************************************************/

    //获取小组文件总数，全部小组--管理员使用
    @Select("select count(*) from oa_file where filegroup is not null;")
    public int groupAllFileNum();

    //获取小组文件列表，全部小组，从第几个到第几个--管理员使用
    @Select("select * from oa_file where filegroup is not null order by fileid limit #{page},#{count};")
    public List<Files> groupAllFileList(@Param("page")int page,@Param("count")int count);

    //根据文件类型查找文件,全部小组--管理员使用
    @Select("select * from oa_file where fileclass=#{fileClass} and filegroup is not null;")
    public List<Files> getGroupAllFileByClass(String fileClass);

    //根据关键字查找文件,全部小组文件--管理员使用
    @Select("select * from oa_file where filegroup is not null and fileshowname like #{fileKey}")
    public List<Files> getGroupAllFileByKey(String fileKey);

    //根据关键字和类型查询全部小组文件--管理员使用
    @Select("select * from oa_file where filegroup is not null and fileclass=#{fileClass} and fileshowname like #{fileKey}")
    public List<Files> getGroupAllFileByClassAndKey(@Param("fileClass")String fileClass,@Param("fileKey")String fileKey);

}
