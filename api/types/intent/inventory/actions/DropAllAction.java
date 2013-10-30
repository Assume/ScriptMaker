package scripts.ScriptMaker.api.types.intent.inventory.actions;

import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Action;

public class DropAllAction extends Action implements Serializable
{

	private static final long serialVersionUID = 1368435444528312890L;

	public DropAllAction()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean run()
	{
		return Inventory.dropAllExcept(-1) == 0;
	}
	
	@Override
	public String toString()
	{
		return "drop all items in inventory";
	}
}
