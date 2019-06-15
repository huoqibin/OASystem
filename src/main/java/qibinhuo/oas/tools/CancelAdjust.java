package qibinhuo.oas.tools;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CancelAdjust implements JavaDelegate {
	private final static Logger logger = LoggerFactory.getLogger(CancelAdjust.class);

	public void execute(DelegateExecution execution)
	{
		logger.info("调用cancelAdjust方法模拟取消薪资调整");
	}
}
