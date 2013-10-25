package scripts.ScriptMaker.api.types.intent.general;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Action;

public class WaitUntilInventoryDoesntContainItem extends Action
{

	private static final long serialVersionUID = 3799150687233480912L;
	private int itemID;
	private long timeOut;

	public WaitUntilInventoryDoesntContainItem(final int itemID, long timeOut)
	{
		this.itemID = itemID;
		this.timeOut = timeOut;
	}

	@Override
	public boolean run()
	{
		return Timing.waitCondition(new Condition()
		{
			@Override
			public boolean active()
			{
				return Inventory.find(itemID).length == 0;
			}	
		}, timeOut);
	}
	
	@Override
	public String toString()
	{
		return "wait until inventory doesn't contain "+itemID;
	}
	
}
