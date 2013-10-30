package scripts.ScriptMaker.api.types.intent.bank;

import java.io.Serializable;

import org.tribot.api2007.Banking;

import scripts.ScriptMaker.api.types.main.Action;

public class DepositAllExceptAction extends Action implements Serializable
{

	private static final long serialVersionUID = 2557236121401440311L;
	private int[] itemIDs;
	
	public DepositAllExceptAction(final int... itemIDs)
	{
		this.itemIDs = itemIDs;
	}

	@Override
	public boolean run()
	{
		return Banking.depositAllExcept(itemIDs) == 0;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder("Deposit all except ");
		for(int i = 0; i < itemIDs.length; i++)
		{
			if(i < itemIDs.length - 1)
			{
				b.append(""+itemIDs[i]+",");
			}
			else
			{
				b.append(""+itemIDs[i]);
			}
		}
		return "Deposit all except "+b.toString();
	}

}
