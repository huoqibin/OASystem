package qibinhuo.oas.tools;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qibinhuo.oas.form.ExpenseAccountForm;

public class BankTransfer implements JavaDelegate {
	private final static Logger logger = LoggerFactory.getLogger(BankTransfer.class);

	public void execute(DelegateExecution execution) {
		ExpenseAccountForm account = (ExpenseAccountForm)execution.getVariable("arg");
		if (Integer.parseInt(account.getMoney()) >= 100) {
			throw new BpmnError("to much");
		} else {
			System.out.println("银行转帐成功");
		}
	}

}
