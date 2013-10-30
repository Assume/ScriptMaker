package scripts.ScriptMaker.api.types.intent.inventory;

import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryDoesNotContainConditional extends Conditional implements Serializable
{


	private static final long serialVersionUID = 1384385056215020925L;
	
	private int itemID;
	
	public InventoryDoesNotContainConditional(final int itemID)
	{
		this.itemID = itemID;
	}

	@Override
	public boolean run()
	{
		return Inventory.find(itemID).length  == 0; 
	}

	public int getItemID()
	{
		return itemID;
	}

	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	
	@Override
	public String toString()
	{
		return "If inventory doesn't contain " +itemID + " ";
	}
}
