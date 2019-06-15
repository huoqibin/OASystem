package qibinhuo.oas.service;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import qibinhuo.oas.form.*;
import qibinhuo.oas.vo.CommentVO;
import qibinhuo.oas.vo.MyListVO;
import qibinhuo.oas.vo.ProcessVO;
import qibinhuo.oas.vo.TaskVO;

import java.io.InputStream;
import java.util.List;

public interface ProcessService {
    //开始请假流程
    public boolean startVacation(VacationForm vacationForm);
    //开始报销流程
    public boolean startExpenseAccount(ExpenseAccountForm expenseAccountForm);
    //开始薪资调整流程
    public boolean startSalaryAdjust(SalaryAdjustForm salaryAdjustForm);
    //开始用印流程
    public boolean startStamp(StampForm stampForm);
    //查询用户请假申请
    public List<ProcessVO> listVacation(String userId);
    //查询用户报销申请
    public List<ProcessVO> listExpenseAccount(String userId);
    //查询用户薪资调整申请
    public List<ProcessVO> listSalaryAdjust(String userId);
    //查询用户用印申请
    public List<ProcessVO> listStamp(String userId);
    //查询用户待办事务
    public List<TaskVO> listTasks(String userId);
    //查询用户所受理的全部任务
    public List<TaskVO> listAssigneeTasks(String userId);
    //用户领取任务
    public void claim(String taskId, String userId);
    //查询一个任务所在流程的开始表单信息
    public List<FormField> getFormFields(String taskId);
    //查询一个任务所在流程的全部评论
    public List<CommentVO> getComments(String taskId);
    //审批通过任务
    public void complete(String taskId, String content, String userId);
    //驳回请求
    public void rejectRequest(String taskId, String content, String userId);
    //获取流程图
    public InputStream getDiagram(String processInstanceId);
    //获取流程定义
    public List<ProcessDefinition> getProcessDefinitionList();
    //中止流程定义
    public void suspendProcessDef(String defId);
    //激活流程定义
    public void activateProcessDef(String defId);
    //获取流程定义图
    public InputStream getProcessDiagram(String defId);

}
