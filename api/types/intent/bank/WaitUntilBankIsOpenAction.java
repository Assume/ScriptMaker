package scripts.ScriptMaker.api.types.intent.bank;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;

import scripts.ScriptMaker.api.types.main.Action;

public class WaitUntilBankIsOpenAction extends Action
{

	private static final long serialVersionUID = -7794359479606083454L;

	private long timeout;
	
	public WaitUntilBankIsOpenAction(long timeout)
	{
		this.timeout = timeout;
	}
	
	@Override
	public boolean run()
	{
		return Timing.waitCondition(new Condition()
		{
			@Override
			public boolean active()
			{
				return Banking.isBankScreenOpen();
			}
		}, timeout);
	}
	
	
	@Override
	public String toString()
	{
		return "wait until bank is open";
	}

}
