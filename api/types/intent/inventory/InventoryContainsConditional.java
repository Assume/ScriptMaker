package scripts.ScriptMaker.api.types.intent.inventory;

import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryContainsConditional extends Conditional implements
	Serializable
{

    private static final long serialVersionUID = -409310374883516427L;

    private int itemID;
    private int amount;

    public InventoryContainsConditional(final int itemID, final int amount)
    {
	this.itemID = itemID;
	this.amount = amount;
    }

    @Override
    public boolean run()
    {
	return Inventory.find(itemID).length >= amount;
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
	return "If inventory contains at least " + amount + " of " + itemID
		+ " ";
    }

}
