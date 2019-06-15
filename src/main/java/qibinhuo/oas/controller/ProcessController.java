package qibinhuo.oas.controller;

import org.activiti.engine.identity.User;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qibinhuo.oas.dao.entity.Message;
import qibinhuo.oas.form.*;
import qibinhuo.oas.service.MessageService;
import qibinhuo.oas.service.ProcessService;
import qibinhuo.oas.tools.DateUtil;
import qibinhuo.oas.vo.CommentVO;
import qibinhuo.oas.vo.ProcessVO;
import qibinhuo.oas.vo.TaskVO;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 * 用来处理流程
 */
@Controller
public class ProcessController {
    private final static Logger logger = LoggerFactory.getLogger(ProcessController.class);
    @Autowired
    private ProcessService processService;

    /**
     * 开始请假流程  （功能需要完善）2019/2/4
     * @param vacationForm
     * @param session
     * @return
     */
    @RequestMapping("/startvacation")
    public String startVacationProcess(VacationForm vacationForm, Model model, HttpSession session) {
        logger.info("请假流程方法开始，表单内容："+vacationForm.toString());
        //调用流程服务开始请假流程
        boolean tof = processService.startVacation(vacationForm);

        //成功返回欢迎页面，否则返回错误页面
        if(tof){
            logger.info("请假流程成功开始,返回信息");
            model.addAttribute("message","请假流程提交成功！");
        }
        else{
            logger.warn("请假流程错误结束,返回信息");
            model.addAttribute("message","请假流程提交失败！");
        }
        return "message";
    }

    /**
     * 开始报销流程
     * @param expenseAccountForm
     * @return
     */
    @RequestMapping("/startexpenseaccount")
    public String startExpenseAccountProcess(ExpenseAccountForm expenseAccountForm, Model model){
        logger.info("报销流程方法开始，报销流程表单信息："+expenseAccountForm.toString());
        //调用流程服务开始报销流程
        boolean tof = processService.startExpenseAccount(expenseAccountForm);

        //成功返回欢迎页面，否则返回错误页面
        if(tof){
            logger.info("报销流程成功开始");
            model.addAttribute("message","报销流程成功提交！");
        }
        else{
            logger.warn("报销流程错误结束");
            model.addAttribute("message","报销流程提交失败！");
        }
        return "message";
    }

    /**
     * 开始薪资调整流程
     * @param salaryAdjustForm
     * @return
     */
    @RequestMapping("/startsalaryadjust")
    public String startSalaryAdjustProcess(SalaryAdjustForm salaryAdjustForm, Model model){
        logger.info("薪资调整流程方法开始，薪资调整表单："+salaryAdjustForm.toString());
        //调用流程服务开始薪资调整流程
        boolean tof = processService.startSalaryAdjust(salaryAdjustForm);

        //成功返回欢迎页面，否则返回错误页面
        if(tof){
            logger.info("薪资调整流程成功开始");
            model.addAttribute("message","薪资调整流程成功提交！");
        }
        else{
            logger.warn("薪资调整流程错误结束");
            model.addAttribute("message","薪资调整流程提交失败！");
        }
        return "message";
    }

    /**
     * 开始用印流程
     * @param stampForm
     * @param model
     * @return
     */
    @RequestMapping("/startstamp")
    public String startStamp(StampForm stampForm, Model model){
        logger.info("用印流程方法开始，用印表单："+stampForm.toString());
        //调用流程服务开始用印流程
        boolean tof = processService.startStamp(stampForm);

        //成功返回欢迎页面，否则返回错误页面
        if(tof){
            logger.info("用印流程成功开始");
            model.addAttribute("message","用印流程成功提交！");
        }
        else{
            logger.warn("用印错误结束");
            model.addAttribute("message","用印流程提交失败！");
        }
        return "message";
    }

    /**
     * 查询用户的请假申请
     * @param session
     * @param model
     * @return
     * （如果@RequestParm获取不到，改用http）
     */
    @RequestMapping("/queryvacationlist")
    public String queryVacationList(HttpSession session, Model model){
        logger.info("查询用户请假申请方法开始");
        //获取用户id
        User user = (User)session.getAttribute("user");
        List<ProcessVO> result = processService.listVacation(user.getId());
        model.addAttribute("processes",result);

        logger.info(user.getId()+"查询请假申请方法结束，返回流程列表页面");
        return "process/myprocesslist";
    }

    /**
     * 查询用户的报销申请
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/queryexpenseaccount")
    public String queryExpenseAccount(HttpSession session, Model model){
        logger.info("查询用户报销申请方法开始");

        //获取用户id
        User user = (User)session.getAttribute("user");
        List<ProcessVO> result = processService.listExpenseAccount(user.getId());
        model.addAttribute("processes",result);

        logger.info(user.getId()+"查询报销申请方法结束，返回流程列表页面");
        return "process/myprocesslist";
    }

    /**
     * 查询用户的薪资调整申请
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/querysalaryadjust")
    public String querySalaryAdjust(HttpSession session, Model model){
        logger.info("查询用户报销申请方法开始");

        //获取用户id
        User user = (User)session.getAttribute("user");
        List<ProcessVO> result = processService.listSalaryAdjust(user.getId());
        model.addAttribute("processes",result);

        logger.info(user.getId()+"查询报销申请方法结束，返回流程列表页面");
        return "process/myprocesslist";
    }

    /**
     * 查询用户的用印申请
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("querystamp")
    public String queryStamp(HttpSession session, Model model){
        logger.info("查询用户用印申请方法开始");

        //获取用户id
        User user = (User)session.getAttribute("user");
        List<ProcessVO> result = processService.listStamp(user.getId());
        model.addAttribute("processes",result);

        logger.info(user.getId()+"查询用印申请方法结束，返回流程列表页面");
        return "process/myprocesslist";
    }

    /**
     * 查询用户的代办任务列表
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/querytasks")
    public String queryTasks(HttpSession session, Model model){
        logger.info("查询用户代办任务方法开始");

        //获取用户id
        User user = (User)session.getAttribute("user");
        List<TaskVO> result = processService.listTasks(user.getId());
        model.addAttribute("tasks",result);
        model.addAttribute("taskType","candidate");

        logger.info(user.getId()+"查询代办任务方法结束，返回任务页面");
        return "process/task";
    }

    /**
     * 查询用户的受理任务列表
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/queryassigneetasks")
    public String queryAssigneeTasks(HttpSession session, Model model){
        logger.info("查询用户受理任务方法开始");

        //获取用户id
        User user = (User)session.getAttribute("user");
        List<TaskVO> result = processService.listAssigneeTasks(user.getId());
        model.addAttribute("tasks",result);
        model.addAttribute("taskType","assignee");

        logger.info(user.getId()+"查询受理任务方法结束,返回任务页面");
        return "process/task";
    }

    /**
     * 用户领取任务
     * @param taskId
     * @param session
     */
    @RequestMapping("/receiveTask/{taskId}")
    public String receiveTask(@PathVariable String taskId, HttpSession session, Model model){
        logger.info("用户领取任务开始，待领取任务id:"+taskId);
        //获取用户id
        User user = (User)session.getAttribute("user");
        processService.claim(taskId,user.getId());
        model.addAttribute("message","领取任务成功！");

        logger.info(user.getId()+"领取任务结束,领取任务id："+taskId);
        return "message";
    }

    /**
     * 获取任务所在的流程信息和评论
     * @param taskId
     * @param model
     * @return
     */
    @RequestMapping("/getprocessinfo/{taskId}")
    public String getProcessInfo(@PathVariable String taskId, Model model) {
        logger.info("获取流程信息方法开始，任务id:"+taskId);

        //获取流程信息
        List<FormField> result1 = processService.getFormFields(taskId);

        model.addAttribute("formFields",result1);
        //获取流程评论
        List<CommentVO> result2 = processService.getComments(taskId);
        model.addAttribute("comments",result2);

        logger.info("获取流程"+taskId+"信息结束，返回任务处理页面");
        return "process/audittask";
    }

    /**
     * 审批通过任务
     * @param taskId
     * @param content
     * @param session
     * @return
     */
    @RequestMapping("/complete")
    public String complete(String taskId, String content, HttpSession session,Model model){
        logger.info("审批通过任务方法开始，任务id:"+taskId+"；审批内容："+content);

        //获取用户id
        User user = (User)session.getAttribute("user");
        //审批通过任务
        processService.complete(taskId,content,user.getId());
        model.addAttribute("message","您已审批通过！");

        logger.info("审批通过任务方法结束");
        return "message";
    }

    /**
     * 驳回请求
     * @param taskId
     * @param content
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/rejectrequest")
    public String rejectRequest(String taskId, String content, HttpSession session, Model model){
        logger.info("驳回请求方法开始，任务id:"+taskId+"；审批内容："+content);

        //获取用户id
        User user = (User)session.getAttribute("user");
        //驳回请求
        processService.rejectRequest(taskId, content, user.getId());
        model.addAttribute("message", "您已驳回请求");

        logger.info("驳回请求方法结束。");
        return "message";
    }

    /**
     * 获取流程图
     * @param processInstanceId
     * @param response
     * @return
     */
    @RequestMapping("/getdiagram/{processInstanceId}")
    public void getDiagram(@PathVariable String processInstanceId, HttpServletResponse response){
        logger.info("获取流程图方法开始，流程id:"+processInstanceId);

        //从数据库中拿到图片流
        InputStream diagram = processService.getDiagram(processInstanceId);
        OutputStream out = null;
        try {
            response.setContentType("multipart/form-data;charset=utf8");
            out = response.getOutputStream();
            out.write(getImgByte(diagram));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                logger.info("获取流程图方法结束。");

            } catch (Exception e) { }
        }
    }

    /**
     * 辅助方法  将输入流转化为Byte数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    private byte[] getImgByte(InputStream inputStream) throws IOException {
        logger.info("调用辅助方法，将输入流转化为Byte数组");
        BufferedInputStream bufin = new BufferedInputStream(inputStream);
        int buffSize = 1024;
        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);

        byte[] temp = new byte[buffSize];
        int size = 0;
        while ((size = bufin.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        bufin.close();
        inputStream.close();
        byte[] content = out.toByteArray();
        out.close();
        return content;
    }

    /**
     * 查询流程定义列表
     * @param model
     * @return
     */
    @RequestMapping("/getprocessdefinition")
    public String getProcessDef(Model model){
        logger.info("管理员功能，查询流程定义列表方法开始");
        List<ProcessDefinition> processDefinitionList = processService.getProcessDefinitionList();
        model.addAttribute("defs",processDefinitionList);
        logger.info("查询流程定义列表结束，返回流程定义页面。");
        return "process/processmanager";
    }

    /**
     * 中止流程定义
     * @param defId
     * @param model
     * @return
     */
    @RequestMapping("/suspendprocessdef/{defId}")
    public String suspendProcessDef(@PathVariable String defId,Model model){
        logger.info("中止流程定义方法开始，流程定义id:"+defId);
        processService.suspendProcessDef(defId);
        model.addAttribute("message",defId+"流程定义成功中止");
        logger.info("中止流程定义方法结束,流程定义id:"+defId);
        return "message";
    }

    /**
     * 激活流程定义
     * @param defId
     * @param model
     * @return
     */
    @RequestMapping("/activateprocessdef/{defId}")
    public String activateProcessDef(@PathVariable String defId,Model model){
        logger.info("激活流程定义方法开始，流程定义id:"+defId);
        processService.activateProcessDef(defId);
        model.addAttribute("message",defId+"流程定义成功激活");
        logger.info("激活流程定义方法开始，流程定义id:"+defId);
        return "message";
    }

    /**
     * 获取流程定义图
     * @param defId
     * @param response
     * @return
     */
    @RequestMapping("getprocessdiagram/{defId}")
    public void getProcessDiagram(@PathVariable String defId,HttpServletResponse response){
        logger.info("获取流程定义图方法开始，流程定义id:"+defId);
        InputStream diagram = processService.getProcessDiagram(defId);
        OutputStream out = null;
        try {
            response.setContentType("multipart/form-data;charset=utf8");
            out = response.getOutputStream();
            out.write(getImgByte(diagram));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                logger.info("获取流程定义图结束。");

            } catch (Exception e) { }
        }
    }

}