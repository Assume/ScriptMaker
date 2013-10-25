package scripts.ScriptMaker.api.types.intent.bank;

import org.tribot.api2007.Banking;

import scripts.ScriptMaker.api.types.main.Action;

public class WithdrawItemAction extends Action
{
	
	private static final long serialVersionUID = -7813562722078338237L;
	private int itemID;
	private int amount;
	
	public WithdrawItemAction(final int itemID, final int amount)
	{
		this.itemID = itemID;
		this.amount = amount;
	}

	@Override
	public boolean run()
	{
		return Banking.withdraw(amount, itemID);
	}
	
	
	@Override
	public String toString()
	{
		return "withdraw " + amount + " of "+itemID;
	}
	

}
