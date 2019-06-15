package qibinhuo.oas.service.impl;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qibinhuo.oas.dao.entity.*;
import qibinhuo.oas.form.*;
import qibinhuo.oas.service.*;
import qibinhuo.oas.tools.DateUtil;
import qibinhuo.oas.vo.CommentVO;
import qibinhuo.oas.vo.ProcessVO;
import qibinhuo.oas.vo.TaskVO;

import java.io.InputStream;
import java.util.*;

@Service
public class ProcessServiceImpl implements ProcessService {
    private final static Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private VacationService vacationService;
    @Autowired
    private ExpenseAccountService expenseAccountService;
    @Autowired
    private SalaryAdjustService salaryAdjustService;

    @Autowired
    private MessageService messageService;
    @Autowired
    private StampService stampService;


/**************************************流程开始服务***********************************************/

    /**
     * 请假流程服务
     * @param vacationForm
     * @return
     */
    @Override
    public boolean startVacation(VacationForm vacationForm) {
        logger.info("调用startVacation方法开始请假流程"+vacationForm.toString());
        // 设置标题
        vacationForm.setTitle(vacationForm.getUserName() + " 的请假申请");
        vacationForm.setBusinessType("请假申请");
        // 查找流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("Vacation").singleResult();
        // 初始化任务参数
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("arg", vacationForm);
        vars.put("pass", true);
        //设置流程发起人
        identityService.setAuthenticatedUserId(vacationForm.getUserId());
        // 启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinition.getKey());
        // 查询第一个任务
        Task firstTask = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        // 设置任务受理人
        taskService.setAssignee(firstTask.getId(), vacationForm.getUserId());
        // 完成任务
        taskService.complete(firstTask.getId(), vars);
        // 记录请假数据
        vacationService.setRecord(vacationForm, processInstance.getId());
        return true;
    }

    /**
     * 报销流程服务
     * @param expenseAccountForm
     * @return
     */
    @Override
    public boolean startExpenseAccount(ExpenseAccountForm expenseAccountForm) {
        logger.info("调用startExpenseAccount开始报销流程服务");

        expenseAccountForm.setTitle(expenseAccountForm.getUserName() + " 的报销申请");
        expenseAccountForm.setBusinessType("报销申请");
        // 查找流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("ExpenseAccount").singleResult();
        // 初始化流程参数
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("arg", expenseAccountForm);
        vars.put("pass", true);
        // 启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinition.getKey());
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        // 完成任务
        taskService.complete(task.getId(), vars);
        // 保存到业务系统的数据库
        expenseAccountService.setRecord(expenseAccountForm, processInstance.getId());
        return true;
    }

    /**
     * 薪资调整流程服务
     * @param salaryAdjustForm
     * @return
     */
    @Override
    public boolean startSalaryAdjust(SalaryAdjustForm salaryAdjustForm) {
        logger.info("调用startSalaryAdjust开始薪资调整流程服务");
        salaryAdjustForm.setBusinessType("薪资调整");
        salaryAdjustForm.setTitle(salaryAdjustForm.getLastName() + " 的调薪申请");
        // 验证用户是否存在
        User user = identityService.createUserQuery().userId(salaryAdjustForm.getUserId()).singleResult();
        if (user == null) {
            throw new RuntimeException("调薪用户不存在");
        }
        // 查找流程定义
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey("SalaryAdjust").singleResult();
        // 初始化参数
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("arg", salaryAdjustForm);
        vars.put("pass", true);
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(pd.getKey());
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        // 完成任务
        taskService.complete(task.getId(), vars);
        // 将数据保存到OA_SALARY_ADJUST表
        salaryAdjustService.setRecord(salaryAdjustForm, pi.getId(), user.getId());
        return true;
    }

    /**
     * 用印流程服务
     * @param stampForm
     * @return
     */
    @Override
    public boolean startStamp(StampForm stampForm) {
        logger.info("调用startStamp开始用印流程服务");
        stampForm.setBusinessType("用印申请");
        stampForm.setTitle(stampForm.getUserName()+"的用印申请");
        //验证用户是否存在
        User user = identityService.createUserQuery().userId(stampForm.getUserId()).singleResult();
        if (user == null) {
            throw new RuntimeException("调薪用户不存在");
        }
        // 查找流程定义
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey("Stamp").singleResult();
        // 初始化参数
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("arg", stampForm);
        vars.put("pass", true);
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(pd.getKey());
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        // 完成任务
        taskService.complete(task.getId(), vars);
        // 将数据保存到OA_STAMP表
        stampService.setRecord(stampForm, pi.getId());
        return true;
    }


/**************************************查询用户申请的服务***********************************************/

    /**
     * 查询用户请假申请
     * @param userId
     * @return
     */
    @Override
    public List<ProcessVO> listVacation(String userId) {
        logger.info("调用listVacation查询请假申请");
        // 查询OA_VACATION表的数据
        List<Vacation> vacs = vacationService.getRecord(userId);
        List<ProcessVO> result = new ArrayList<ProcessVO>();
        for (Vacation vac : vacs) {
            // 查询流程实例
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(vac.getProcessInstanceId()).singleResult();
            if (processInstance != null) {
                // 查询流程参数
                BaseForm var = (BaseForm)runtimeService.getVariable(processInstance.getId(), "arg");
                // 封装界面对象
                ProcessVO processVO = new ProcessVO();
                processVO.setTitle(var.getTitle());
                processVO.setRequestDate(var.getRequestDate());
                processVO.setId(processInstance.getId());
                result.add(processVO);
            }
        }
        return result;
    }

    /**
     * 查询报销申请
     * @param userId
     * @return
     */
    @Override
    public List<ProcessVO> listExpenseAccount(String userId) {
        logger.info("调用listExpenseAccount查询报销申请");
        List<ExpenseAccount> accounts = expenseAccountService.getRecord(userId);
        List<ProcessVO> result = new ArrayList<ProcessVO>();
        for (ExpenseAccount account : accounts) {
            // 查询流程实例
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(account.getProcessInstanceId()).singleResult();
            if (processInstance != null) {
                // 查询流程参数
                BaseForm var = (BaseForm) this.runtimeService.getVariable(processInstance.getId(), "arg");
                // 封装界面对象
                ProcessVO processVO = new ProcessVO();
                processVO.setTitle(var.getTitle());
                processVO.setRequestDate(var.getRequestDate());
                processVO.setId(processInstance.getId());
                result.add(processVO);
            }
        }
        return result;
    }

    /**
     * 查询用户薪资调整申请
     * @param userId
     * @return
     */
    @Override
    public List<ProcessVO> listSalaryAdjust(String userId) {
        logger.info("调用listSalaryAdjust查询薪资调整申请");
        List<SalaryAdjust> salarys = salaryAdjustService.getRecord(userId);
        List<ProcessVO> result = new ArrayList<ProcessVO>();
        for (SalaryAdjust salary : salarys) {
            // 查询流程实例
            ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery().processInstanceId(salary.getProcessInstanceId()).singleResult();
            if (processInstance != null) {
                // 查询流程参数
                BaseForm var = (BaseForm) this.runtimeService.getVariable(processInstance.getId(), "arg");
                // 封装界面对象
                ProcessVO processVO = new ProcessVO();
                processVO.setTitle(var.getTitle());
                processVO.setRequestDate(var.getRequestDate());
                processVO.setId(processInstance.getId());
                result.add(processVO);
            }
        }
        return result;
    }

    /**
     * 查询用户用印申请
     * @param userId
     * @return
     */
    @Override
    public List<ProcessVO> listStamp(String userId) {
        logger.info("调用listSalaryAdjust查询薪资调整申请");
        List<Stamp> stamps = stampService.getRecord(userId);
        List<ProcessVO> result = new ArrayList<ProcessVO>();
        for (Stamp stamp : stamps) {
            // 查询流程实例
            ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery().processInstanceId(stamp.getProcessInstanceId()).singleResult();
            if (processInstance != null) {
                // 查询流程参数
                BaseForm var = (BaseForm) this.runtimeService.getVariable(processInstance.getId(), "arg");
                // 封装界面对象
                ProcessVO processVO = new ProcessVO();
                processVO.setTitle(var.getTitle());
                processVO.setRequestDate(var.getRequestDate());
                processVO.setId(processInstance.getId());
                result.add(processVO);
            }
        }
        return result;
    }

/**************************************用户任务相关的服务***********************************************/

    /**
     * 查询用户的待办任务列表
     * @param userId
     * @return
     */
    @Override
    public List<TaskVO> listTasks(String userId) {
        logger.info("调用listTasks查询用户代办任务列表");
        // 查询用户所属的用户组
        Group group = identityService.createGroupQuery().groupMember(userId).singleResult();
        // 根据用户组查询任务
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(group.getId()).list();
        return createTaskVOList(tasks);
    }

    /**
     * 查询用户所受理的全部任务
     * @param userId
     * @return
     */
    @Override
    public List<TaskVO> listAssigneeTasks(String userId) {
        logger.info("调用listAssigneeTasks查询用户受理的全部任务");
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).list();
        // 将Task集合转为TaskVO集合
        return createTaskVOList(tasks);
    }

    /**
     * 辅助方法----将Task集合转为TaskVO集合
     * @param tasks
     * @return
     */
    private List<TaskVO> createTaskVOList(List<Task> tasks) {
        logger.info("调用辅助方法将Task集合转化为TaskVO集合");
        List<TaskVO> result = new ArrayList<TaskVO>();
        for (Task task : tasks) {
            // 查询流程实例
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            // 查询流程参数
            BaseForm baseForm = (BaseForm)runtimeService.getVariable(processInstance.getId(), "arg");
            // 封装值对象
            TaskVO taskVO = new TaskVO();
            taskVO.setProcessInstanceId(task.getProcessInstanceId());
            taskVO.setRequestDate(baseForm.getRequestDate());
            taskVO.setRequestUser(baseForm.getUserName());
            taskVO.setTitle(baseForm.getTitle());
            taskVO.setTaskId(task.getId());
            taskVO.setProcessInstanceId(processInstance.getId());
            result.add(taskVO);
        }
        return result;
    }

    /**
     * 领取任务
     * @param taskId  任务id
     * @param userId  领取人id
     */
    @Override
    public void claim(String taskId, String userId) {
        logger.info("调用claim方法领取任务");
        taskService.claim(taskId, userId);
    }

    /**
     * 查询一个任务所在流程的开始表单信息
     * @param taskId
     * @return
     */
    @Override
    public List<FormField> getFormFields(String taskId) {
        logger.info("调用getFormFields方法查询一个任务的开始表单信息");
        // 根据任务查询流程实例
        ProcessInstance processInstance = getProcessInstance(taskId);
        // 获取流程参数
        BaseForm baseForm = (BaseForm)runtimeService.getVariable(processInstance.getId(), "arg");
        System.out.println("BaseForm流程参数："+baseForm.toString());
        // 返回表单集合
        List<FormField> formFields = baseForm.getFormFields();
        for(FormField formField:formFields){
            System.out.println(formField.toString());
        }
        return formFields;
    }

    /**
     * 查询一个任务所在流程的全部评论
     * @param taskId
     * @return
     */
    @Override
    public List<CommentVO> getComments(String taskId) {
        logger.info("调用getComments方法查询一个任务所在流程的全部评论");
        ProcessInstance processInstance = getProcessInstance(taskId);
        List<CommentVO> result = new ArrayList<CommentVO>();
        List<Comment> comments = taskService.getProcessInstanceComments(processInstance.getId());
        for (Comment c : comments) {
            // 查询用户
            User user = identityService.createUserQuery().userId(c.getUserId()).singleResult();
            CommentVO commentVO = new CommentVO();
            commentVO.setContent(c.getFullMessage());
            commentVO.setTime(DateUtil.getDateString(c.getTime()));
            commentVO.setUserName(user.getLastName());
            result.add(commentVO);
        }
        return result;
    }

    /**
     * 审批通过任务
     * @param taskId
     * @param content
     * @param userId
     */
    @Override
    public void complete(String taskId, String content, String userId) {
        logger.info("调用complete方法审批通过任务");
        ProcessInstance processInstance = getProcessInstance(taskId);
        identityService.setAuthenticatedUserId(userId);
        //系统消息通知流程申请人
        String receiver = processInstance.getStartUserId();  //获取流程申请者作为接收方
        String processTitle = processInstance.getName();    //获取流程名称
        //生成Message对象
        Message message = new Message();
        message.setDate(DateUtil.getDateString(new Date()));
        message.setSender(userId);
        message.setReceiver(receiver);
        message.setTitle("流程审批通知");
        message.setType(0);
        message.setContent("你的申请被 "+userId+"审批通过,请查看流程进度。");
        logger.info("发送系统消息："+message.toString());
        //发送系统消息
        messageService.sendMessage(message);

        // 添加评论
        taskService.addComment(taskId, processInstance.getId(), content);
        // 完成任务
        taskService.complete(taskId);
    }

    /**
     * 驳回请求
     * @param taskId
     * @param comment
     * @param userId
     */
    @Override
    public void rejectRequest(String taskId, String comment, String userId) {
        logger.info("调用rejectRequest方法驳回请求");
        identityService.setAuthenticatedUserId(userId);
        ProcessInstance processInstance = getProcessInstance(taskId);

        //系统消息通知流程申请人
        String receiver = processInstance.getStartUserId();  //获取流程申请者作为接收方
        String processTitle = processInstance.getName();    //获取流程名称
        //生成Message对象
        Message message = new Message();
        message.setDate(DateUtil.getDateString(new Date()));
        message.setSender(userId);
        message.setReceiver(receiver);
        message.setTitle("流程审批通知");
        message.setType(0);
        message.setContent("你的申请已被 "+userId+"拒绝。其回复为："+comment);
        logger.info("发送系统消息："+message.toString());
        //发送系统消息
        messageService.sendMessage(message);

        //删除流程
        runtimeService.deleteProcessInstance(processInstance.getId(),comment);
//        taskService.addComment(taskId, processInstance.getId(), comment);
//        Map<String, Object> vars = new HashMap<String, Object>();
//        vars.put("pass", false);
//        taskService.complete(taskId, vars);
    }

    /**
     * 根据任务id获取流程实例
     * @param taskId
     * @return
     */
    private ProcessInstance getProcessInstance(String taskId) {
        logger.info("调用getProcessInstance方法获取流程实例");
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        // 根据任务查询流程实例
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        return processInstance;
    }

    /**
     * 获取流程图
     * @param processInstanceId
     * @return
     */
    @Override
    public InputStream getDiagram(String processInstanceId) {
        logger.info("调用getDiagram方法获取流程图");
        // 查询流程实例
        ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        // 查询流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(processInstance.getProcessDefinitionId()).singleResult();
        // 获取BPMN模型对象
        BpmnModel model = repositoryService.getBpmnModel(processDefinition.getId());
        // 定义使用宋体
        String fontName = "宋体";
        // 获取流程实实例当前点的节点，需要高亮显示
        List<String> currentActs = runtimeService.getActiveActivityIds(processInstance.getId());
        // BPMN模型对象、图片类型、显示的节点
        InputStream inputStream = processEngine
                .getProcessEngineConfiguration()
                .getProcessDiagramGenerator()
                .generateDiagram(model, "png", currentActs, new ArrayList<String>(),
                        fontName, fontName, fontName,null, 1.0);
        return inputStream;
    }

    /**
     * 获取流程定义列表
     * @return
     */
    @Override
    public List<ProcessDefinition> getProcessDefinitionList() {
        logger.info("调用getProcessDefinitionList方法获取流程定义列表");
        return repositoryService.createProcessDefinitionQuery().list();
    }

    /**
     * 中止流程定义
     * @param defId
     */
    @Override
    public void suspendProcessDef(String defId) {
        logger.info("调用suspendProcessDef方法中止流程定义");
        repositoryService.suspendProcessDefinitionById(defId);
    }

    /**
     * 激活流程定义
     * @param defId
     */
    @Override
    public void activateProcessDef(String defId) {
        logger.info("调用activateProcessDef方法重新激活流程定义");
        repositoryService.activateProcessDefinitionById(defId);
    }

    /**
     * 获取流程定义图
     * @param defId
     * @return
     */
    @Override
    public InputStream getProcessDiagram(String defId) {
        logger.info("调用getProcessDiagram获取流程定义图");
        return repositoryService.getProcessDiagram(defId);
    }

}
