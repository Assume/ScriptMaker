package scripts.ScriptMaker.api.types.intent.inventory.actions;

import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Action;

public class DropAllExceptAction extends Action implements Serializable
{

	private static final long serialVersionUID = -8639403175335235135L;
	private int[] itemID;

	public DropAllExceptAction(int... itemID)
	{
		this.itemID = itemID;
	}

	@Override
	public boolean run()
	{
		return Inventory.dropAllExcept(itemID) == 0;
	}
	
	@Override
	public String toString()
	{
		return "drop all except "+itemID;
	}

}
