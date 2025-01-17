package scripts.ScriptMaker.api.types.intent.bank;

import java.io.Serializable;

import org.tribot.api2007.Banking;

import scripts.ScriptMaker.api.types.main.Action;

public class OpenBankAction extends Action implements Serializable
{

	private static final long serialVersionUID = -2923123199297290012L;

	@Override
	public boolean run()
	{
		return Banking.openBank();
	}
	
	@Override
	public String toString()
	{
		return " Open bank";
	}

}
