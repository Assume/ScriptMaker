package scripts.ScriptMaker.api.types.intent.inventory;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryIsNotFullConditional extends Conditional
{
	
	private static final long serialVersionUID = -5094858302577881918L;

	@Override
	public boolean run()
	{
		return !Inventory.isFull();
	}

	@Override
	public String toString()
	{
		return "If inventory is not full ";
	}
	
}
