package scripts.ScriptMaker.api.types.intent.bank;

import org.tribot.api2007.Banking;

import scripts.ScriptMaker.api.types.main.Action;

public class CloseBankAction extends Action
{

	private static final long serialVersionUID = 3094398149761309568L;

	@Override
	public boolean run()
	{
		return Banking.close();
	}
	

	@Override
	public String toString()
	{
		return "Close bank";
	}
	
}
