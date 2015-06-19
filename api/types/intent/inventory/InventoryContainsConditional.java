package scripts.ScriptMaker.api.types.intent.inventory;

import java.io.Serializable;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryContainsConditional extends Conditional implements
		Serializable {

	private static final long serialVersionUID = -409310374883516427L;

	private int itemID;
	private int amount;

	public InventoryContainsConditional(final int itemID, final int amount) {
		this.itemID = itemID;
		this.amount = amount;
	}

	@Override
	public boolean run() {
		int tot = 0;
		RSItem[] x = Inventory.find(itemID);
		for(RSItem y : x)
			tot += y.getStack();
		return tot>= amount;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	@Override
	public String toString() {
		return "If inventory contains at least " + amount + " of " + itemID
				+ " ";
	}

}
