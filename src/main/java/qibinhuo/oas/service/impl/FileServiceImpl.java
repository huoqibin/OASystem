package qibinhuo.oas.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.FilesDao;
import qibinhuo.oas.dao.entity.Files;
import qibinhuo.oas.form.Pages;
import qibinhuo.oas.service.FileService;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FilesDao fileDao;

    /**
     * 获取公司文件总数
     * @return  公司文件总数
     */
    @Override
    public int companyFileNum() {
        return fileDao.companyFileNum();
    }

    /**
     * 获取某小组文件总数
     * @param groupId
     * @return
     */
    @Override
    public int groupFileNum(String groupId) {
        return fileDao.groupFileNum(groupId);
    }

    /**
     * 获取全部小组文件总数
     * @return
     */
    @Override
    public int groupAllFileNum() {
        return fileDao.groupAllFileNum();
    }

    /**
     * 获取公司文件列表
     * @param pages
     * @return
     */
    @Override
    public List<Files> componyFileList(Pages pages) {
        return fileDao.componyFileList(pages.getStartLine(),20);
    }

    /**
     * 获取某小组文件列表
     * @param groupId
     * @param pages
     * @return
     */
    @Override
    public List<Files> groupFileList(String groupId, Pages pages) {
//        System.out.println("Service参数"+groupId+pages.getStartLine());
        List<Files> fileList = fileDao.groupFileList(groupId,pages.getStartLine(),10);
        return fileList;
    }

    /**
     * 获取全部小组文件列表
     * @param pages
     * @return
     */
    @Override
    public List<Files> groupAllFileList(Pages pages) {
        List<Files> fileList = fileDao.groupAllFileList(pages.getStartLine(),10);
        return fileList;
    }

    /**
     * 通过分类查询公司文件
     * @param fileClass
     * @return
     */
    @Override
    public List<Files> getCompanyFileByClass(String fileClass) {
        return fileDao.getCompanyFileByClass(fileClass);
    }

    /**
     * 通过分类查询小组文件
     * @param groupId
     * @param fileClass
     * @return
     */
    @Override
    public List<Files> getGroupFileByClass(String groupId, String fileClass) {
        return fileDao.getGroupFileByClass(groupId,fileClass);
    }

    /**
     * 根据分类查询全部小组文件
     * @param fileClass
     * @return
     */
    @Override
    public List<Files> getGroupAllFileByClass(String fileClass) {
        return fileDao.getGroupAllFileByClass(fileClass);
    }

    /**
     * 根据关键字查询公司文件
     * @param fileKey
     * @return
     */
    @Override
    public List<Files> getCompanyFileByKey(String fileKey) {
        String FK = "%"+fileKey+"%";
        return fileDao.getCompanyFileByKey(FK);
    }

    /**
     * 根据关键字和分类查询公司文件列表
     * @param fileClass
     * @param fileKey
     * @return
     */
    @Override
    public List<Files> getCompanyFileByClassAndKey(String fileClass, String fileKey) {
        String FK = "%"+fileKey+"%";
        return fileDao.getCompanyFileByClassAndKey(fileClass,FK);
    }

    /**
     * 根据分类和关键字查询某个小组分类列表
     * @param group
     * @param fileClass
     * @param fileKey
     * @return
     */
    @Override
    public List<Files> getGroupFileByClassAndKey(String group, String fileClass, String fileKey) {
        String FK = "%"+fileKey+"%";
//        System.out.println("参数"+group+fileClass+FK);
        return fileDao.getGroupFileByClassAndKey(group,fileClass,FK);
    }

    /**
     * 根据关键字和文件类型查询全部小组文件列表
     * @param fileClass
     * @param fileKey
     * @return
     */
    @Override
    public List<Files> getGroupAllFileByClassAndKey(String fileClass, String fileKey) {
        String FK = "%"+fileKey+"%";
        return fileDao.getGroupAllFileByClassAndKey(fileClass,FK);
    }

    /**
     * 根据关键字查询某小组文件
     * @param groupId
     * @param fileKey
     * @return
     */
    @Override
    public List<Files> getGroupFileByKey(String groupId, String fileKey) {
        String FK = "%"+fileKey+"%";
        return fileDao.getGroupFileByKey(groupId,FK);
    }

    /**
     * 根据关键字查询全部小组文件
     * @param fileKey
     * @return
     */
    @Override
    public List<Files> getGroupAllFileByKey(String fileKey) {
        String FK = "%"+fileKey+"%";
        return fileDao.getGroupAllFileByKey(FK);
    }

    /**
     * 上传公司文件
     * @param files
     */
    @Override
    public void addCompanyFile(Files files) {
        fileDao.addCompanyFile(files);
    }

    /**
     * 上传小组文件
     * @param files
     */
    @Override
    public void addGroupFile(Files files) {
        fileDao.addGroupFile(files);
    }

    /**
     * 获取文件的保存位置
     * @param fileRealName
     * @return
     */
    @Override
    public String getFileSrc(String fileRealName) {
        return fileDao.getFileSrc(fileRealName);
    }

    @Override
    public String getFileUploader(String fileRealName) {
        return fileDao.getFileUploader(fileRealName);
    }

    /**
     * 删除文件
     * @param fileRealName
     */
    @Override
    public void deleteFile(String fileRealName) {
        fileDao.deleteFile(fileRealName);
    }
}