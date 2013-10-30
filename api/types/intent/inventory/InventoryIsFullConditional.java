package scripts.ScriptMaker.api.types.intent.inventory;

import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryIsFullConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 6075013446898348216L;

	public InventoryIsFullConditional()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean run()
	{
		return Inventory.isFull();
	}

	
	@Override
	public String toString()
	{
		return "If inventory is full ";
	}
}
