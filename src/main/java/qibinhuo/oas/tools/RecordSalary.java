package qibinhuo.oas.tools;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecordSalary implements JavaDelegate {
    private final static Logger logger = LoggerFactory.getLogger(RecordSalary.class);

    public void execute(DelegateExecution execution)
    {
        logger.info("调用recordSalary方法模拟薪资调整");
    }

}
