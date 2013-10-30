package scripts.ScriptMaker.api.types.intent.inventory;

import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryIsEmptyConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = -6713940523552042307L;

	public InventoryIsEmptyConditional()
	{
		
	}

	@Override
	public boolean run()
	{
		return Inventory.getAll().length == 0;
	}
	
	@Override
	public String toString()
	{
		return "If inventory is empty ";
	}

}
