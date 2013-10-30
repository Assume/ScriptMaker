package scripts.ScriptMaker.api.types.intent.bank;

import java.io.Serializable;

import org.tribot.api2007.Banking;

import scripts.ScriptMaker.api.types.main.Action;

public class DepositAllAction extends Action implements Serializable
{

	private static final long serialVersionUID = -1699901329900480080L;

	@Override
	public boolean run()
	{
		return Banking.depositAll() == 0;
	}
	
	
	@Override
	public String toString()
	{
		return "Deposit all";
	}
	
}
