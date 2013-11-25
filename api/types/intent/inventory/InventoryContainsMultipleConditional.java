package scripts.ScriptMaker.api.types.intent.inventory;

import java.util.Arrays;
import java.util.List;

import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryContainsMultipleConditional extends Conditional
{

    private static final long serialVersionUID = 11235234234234L;

    private Integer[] itemID;
    private List<Integer> list;

    public InventoryContainsMultipleConditional(final Integer[] itemID)
    {
	this.itemID = itemID;
	list = Arrays.asList(itemID);
    }

    @Override
    public boolean run()
    {
	return Inventory.find(Inventory
		.generateFilterGroup(new Filter<RSItem>()
		{

		    @Override
		    public boolean accept(RSItem arg0)
		    {
			return list.contains(arg0.getID());
		    }
		})).length > 0;
    }

    public Integer[] getItemID()
    {
	return itemID;
    }

    public void setItemID(Integer[] itemID)
    {
	this.itemID = itemID;
    }

    @Override
    public String toString()
    {
	StringBuilder b = new StringBuilder();
	b.append("if inventory contains: ");
	for (int x : this.itemID)
	    b.append(x + ", ");
	return b.toString();
    }

}
