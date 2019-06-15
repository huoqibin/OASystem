package qibinhuo.oas.controller;

import org.activiti.engine.identity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import qibinhuo.oas.dao.entity.Files;
import qibinhuo.oas.form.FileForm;
import qibinhuo.oas.form.Pages;
import qibinhuo.oas.form.SelectFileForm;
import qibinhuo.oas.service.FileService;
import qibinhuo.oas.tools.DateUtil;
import qibinhuo.oas.vo.UserVO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
public class FileController {
    private final static Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     * @param multiReq
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadfile")
    public String uploadFile(MultipartHttpServletRequest multiReq, Model model) throws IOException {
        logger.info("上传文件方法开始");
        FileForm fileForm = new FileForm();
        fileForm.setUserId(multiReq.getParameter("uploader"));  //用户名
        fileForm.setGroupId(multiReq.getParameter("groupId"));  //用户组
        fileForm.setType(Integer.valueOf(multiReq.getParameter("type")));   //类型
        fileForm.setFileClass(multiReq.getParameter("fileClass"));    //分类
        logger.info("待上传文件信息："+fileForm.toString());
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file").getOriginalFilename();
        // 截取上传文件的文件名
        String uploadFileName = uploadFilePath.substring(
                uploadFilePath.lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));
        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(
                uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //生成唯一的文件名
            String fileRealName = uploadFileName+DateUtil.getDateString(new Date())+ RandomStringUtils.random(4, false, true);
            String SqlFile = "";
            String fileSrc = "C:\\工作区\\oas\\src\\main\\resources\\files\\"+fileRealName+"."+uploadFileSuffix;
            fis = (FileInputStream) multiReq.getFile("file").getInputStream();
            fos = new FileOutputStream(new File(fileSrc));
            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1){
                fos.write(temp,0,temp.length);
                fos.flush();
                i = fis.read(temp);
            }

            //记录到数据库
            Files thefile = new Files();
            thefile.setFileUploader(fileForm.getUserId());    //设置上传者
            thefile.setFileClass(fileForm.getFileClass());    //设置文件分类
            thefile.setFileCreatetime(DateUtil.getDateString(new Date()));    //设置文件创建日期
            thefile.setFileShowName(uploadFileName);    //文件展示名
            thefile.setFileRealName(fileRealName);    //文件真实名
            thefile.setFileSrc(fileSrc);    //文件保存位置
            if(fileForm.getType()==1){
                thefile.setFileGroup(fileForm.getGroupId());    //设置分组
                fileService.addGroupFile(thefile);
            }else{
                fileService.addCompanyFile(thefile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("message","上传文件成功！");
        logger.info("上传文件结束,返回信息");
        return "message";
    }

    /**
     * 下载文件
     * @param fileRealName
     * @param res
     * @param model
     * @return
     */
    @RequestMapping("/downloadfile/{fileRealName}")
    public String testDownload(@PathVariable String fileRealName,HttpServletResponse res,Model model) {
        logger.info("下载文件方法开始");
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileRealName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            //获取文件保存位置
            String fileSrc = fileService.getFileSrc(fileRealName);
            bis = new BufferedInputStream(new FileInputStream(new File(fileSrc)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("message","文件下载成功！");
        logger.info("下载文件方法结束，返回消息页面");
        return "message";
    }

    /**
     * 删除文件
     * @param fileRealName
     * @param model
     * @return
     */
    @RequestMapping("/deletefile/{fileRealName}")
    public String deleteFile(@PathVariable String fileRealName,Model model,HttpSession session){
        logger.info("删除文件方法开始，待删除的文件名："+fileRealName);
        //获取当前用户
        User user = (User)session.getAttribute("user");
        String userId = user.getId();
        //获取文件上传者
        String uploader = fileService.getFileUploader(fileRealName);
        System.out.println(userId+uploader);
        if(!userId.equals(uploader)){
            model.addAttribute("message","无权删除该文件！");
            logger.warn("无权删除文件，返回消息页面");
            return "message";
        }
        //1. 查出文件位置
        String filesrc = fileService.getFileSrc(fileRealName);
        //2. 从磁盘上删除该文件
        File file = new File(filesrc);
        file.delete();
        //3. 从数据库删除文件记录
        fileService.deleteFile(fileRealName);
        model.addAttribute("message","文件删除成功！");
        logger.info("删除文件成功，返回消息页面");
        return "message";
    }

    /**
     * 获取公司文件列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/getcompanyfile/{page}")
    public String getCompanyFile(@PathVariable int page, Model model){
        logger.info("获取公司文件列表开始，当前获取页数："+page);

        Pages pages = new Pages();
        if(page<=0) pages.setStartPage(1);
        else pages.setStartPage(page);
        pages.setStartLine((page-1)*20);

        //获取总页数
        int totalpage = fileService.companyFileNum();
        pages.setFullLine(totalpage);
        pages.setFullPage(totalpage/20+1);

        //获取第page页的记录
        List<Files> fileList = fileService.componyFileList(pages);
//        System.out.println(pages.toString());
        model.addAttribute("fileList",fileList);
        model.addAttribute("currentTpye",0);
        model.addAttribute("page",pages);
        logger.info("获取公司文件列表结束，返回文件列表页面");
        return "file/filelist";
    }

    /**
     * 获取某小组文件列表
     * @param page
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/getgroupfile/{page}")
    public String getGroupFile(@PathVariable int page, Model model,HttpSession session){
        logger.info("获取某小组文件列表开始，当前页面："+page);

        Pages pages = new Pages();
        if(page <= 0) pages.setStartPage(1);
        else pages.setStartPage(page);
        pages.setStartLine((page-1)*20);

        UserVO userVO = (UserVO)session.getAttribute("userVO");
        String groupId = userVO.getGroupId();
        int totalNum = fileService.groupFileNum(groupId);
        pages.setFullLine(totalNum);
        pages.setFullPage(totalNum/20+1);

        List<Files> fileList = fileService.groupFileList(groupId,pages);
//        System.out.println("结果"+fileList.toString());
//        System.out.println(pages.toString());
        model.addAttribute("fileList",fileList);
        model.addAttribute("currentTpye",1);
        model.addAttribute("page",pages);

        logger.info("获取"+groupId+"小组文件列表结束,返回文件列表页面");
        return "file/filelist";
    }

    /**
     * 查找文件--包括对公司、小组文件的关键字检索和分类检索
     * @param selectFileForm
     * @param currentType
     * @param model
     * @return
     */
    @RequestMapping("/selectfile")
    public String selectFile(SelectFileForm selectFileForm,int currentType,HttpSession session,Model model){
        logger.info("查询文件方法开始:"+selectFileForm.toString());
        List<Files> fileList = null;
        String keyWord = selectFileForm.getKeyWord();
        String fileClass = selectFileForm.getFileClass();
        UserVO userVO = (UserVO)session.getAttribute("userVO");
        String groupId = userVO.getGroupId();

        if(currentType == 0){    //公司文件
            if(!keyWord.equals("") && keyWord != null
                && !fileClass.equals("") && fileClass != null){
                logger.info("当前是根据类别和关键字查找公司文件");
                fileList = fileService.getCompanyFileByClassAndKey(fileClass,keyWord);
            }else if(!fileClass.equals("") && fileClass != null){    //根据类别检索公司文件
                logger.info("当前仅根据类别查找公司文件");
                fileList = fileService.getCompanyFileByClass(fileClass);
            }else if(!keyWord.equals("") && keyWord != null){
                logger.info("当前仅根据关键字查找公司文件");
                fileList = fileService.getCompanyFileByKey(fileClass);
            }
        }else{    //查询某一小组
            if(!keyWord.equals("") && keyWord != null
                    && !fileClass.equals("") && fileClass != null){
                logger.info("当前是根据类别和关键字查找某个小组文件");
                fileList = fileService.getGroupFileByClassAndKey(groupId,fileClass,keyWord);
            }
            else if(!keyWord.equals("") && keyWord != null){    //根据关键字检索小组文件
                logger.info("当前仅根据关键字查找某小组文件");
                fileList = fileService.getGroupFileByKey(groupId,keyWord);
            }
            else if(!fileClass.equals("") && fileClass != null){    //根据类别检索小组文件
                logger.info("当前仅根据类别查找某小组文件");
                fileList = fileService.getGroupFileByClass(groupId,fileClass);
            }
        }
        model.addAttribute("fileList",fileList);
        model.addAttribute("currentType",currentType);
        logger.info("查询文件方法结束，返回文件列表");
        return "file/filelist";
    }



/**********************************管理员管理文件方法****************************************************/
    /**
     * 获取公司文件列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/getcompanyallfile/{page}")
    public String getCompanyAllFile(@PathVariable int page, Model model){
        logger.info("获取公司文件列表开始，当前获取页数："+page);
        Pages pages = new Pages();
        if(page<=0) pages.setStartPage(1);
        else pages.setStartPage(page);
        pages.setStartLine((page-1)*20);

        //获取总页数
        int totalpage = fileService.companyFileNum();
        pages.setFullLine(totalpage);
        pages.setFullPage(totalpage/20+1);

        //获取第page页的记录
        List<Files> fileList = fileService.componyFileList(pages);
//        System.out.println(pages.toString());
        model.addAttribute("fileList",fileList);
        model.addAttribute("currentTpye",0);
        model.addAttribute("page",pages);
        logger.info("获取公司文件列表结束，返回文件列表页面");
        return "file/managerfilelist";
    }

    /**
     * 获取全部小组文件列表(管理员)
     * @param page
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/getgroupallfile/{page}")
    public String getGroupAllFile(@PathVariable int page, Model model,HttpSession session){
        logger.info("管理员方法，获取全部小组文件列表,page="+page);

        Pages pages = new Pages();
        if(page == 0) pages.setStartPage(1);
        else pages.setStartPage(page);
        pages.setStartLine((page-1)*20);

        int totalMum = 1;
        List<Files> fileList = null;

        totalMum = fileService.groupAllFileNum();
        pages.setFullLine(totalMum);
        int totalPage = totalMum/20+1;

        if(totalPage == 0) totalPage =1;
        if(totalPage<page || page < 0){
            model.addAttribute("message","页数非法！");
            return "message";
        }
        pages.setFullPage(totalPage);
        fileList = fileService.groupAllFileList(pages);
//        System.out.println(pages.toString());
        model.addAttribute("fileList",fileList);
        model.addAttribute("currentTpye",1);
        model.addAttribute("page",pages);

        logger.info("获取全部小组文件列表结束，返回文件列表页面");
        return "file/managerfilelist";
    }

    /**
     * 查找全部小组文件（管理员）
     * @param selectFileForm
     * @param currentType
     * @param model
     * @return
     */
    @RequestMapping("/selectallfile")
    public String selectAllFile(SelectFileForm selectFileForm,int currentType,HttpSession session,Model model){
        logger.info("管理员功能，查询文件方法开始");
        List<Files> fileList = null;
        String keyWord = selectFileForm.getKeyWord();
        String fileClass = selectFileForm.getFileClass();

        if(currentType == 0){    //公司文件
            if(!keyWord.equals("") && keyWord != null
                    && !fileClass.equals("") && fileClass != null){
                logger.info("当前是管理员功能，根据关键字和列别查询公司文件");
                fileList = fileService.getCompanyFileByClassAndKey(fileClass,keyWord);
            }else if(!fileClass.equals("") && fileClass != null){    //根据类别检索公司文件
                logger.info("当前是管理员功能，仅根据类别查询公司文件");
                fileList = fileService.getCompanyFileByClass(fileClass);
            }else if(!keyWord.equals("") && keyWord != null){
                logger.info("当前是管理员功能，仅根据关键字查询公司文件");
                fileList = fileService.getCompanyFileByKey(fileClass);
            }
        } else {
            if(!keyWord.equals("") && keyWord != null && !fileClass.equals("") && fileClass != null){
                logger.info("当前是管理员功能，根据关键字和类别查询全部小组文件");
                fileList = fileService.getGroupAllFileByClassAndKey(fileClass,keyWord);
            } else if(!keyWord.equals("") && keyWord != null){    //根据关键字检索小组文件
                logger.info("当前是管理员功能，仅根据关键字查询全部小组文件");
                fileList = fileService.getGroupAllFileByKey(keyWord);
            }
            else if(!fileClass.equals("") && fileClass != null){    //根据类别检索小组文件
                logger.info("当前是管理员功能，仅根据类别查询全部小组文件");
                fileList = fileService.getGroupAllFileByClass(fileClass);
            }
        }

        model.addAttribute("fileList",fileList);
        model.addAttribute("currentType",currentType);

        logger.info("管理员查询文件方法结束，返回文件列表页面");
        return "file/managerfilelist";
    }

}
