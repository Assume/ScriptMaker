package scripts.ScriptMaker.api.types.intent.inventory.actions;

import java.io.Serializable;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;

import scripts.ScriptMaker.api.types.main.Action;

public class CustomItemAction extends Action implements Serializable
{

	private static final long serialVersionUID = 5379878144716138839L;
	private int itemID;
	private String action;

	public CustomItemAction(final int itemID, final String action)
	{
		this.itemID = itemID;
		this.action = action;
	}

	@Override
	public boolean run()
	{
		Inventory.open();
		RSItem[] items = Inventory.find(itemID);
		if (items.length == 0)
			return true;
		return items[0].click(action);
	}

	@Override
	public String toString()
	{
		return "click "+itemID + " with the action "+this.action;
	}
	
}
