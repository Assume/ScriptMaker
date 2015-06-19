package scripts.ScriptMaker.api.types.intent.inventory;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InventoryContainsLessThanConditional extends Conditional {

	private static final long serialVersionUID = 11238482343313123L;
	private int id;
	private int amount;

	public InventoryContainsLessThanConditional(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	@Override
	public boolean run() {
		int tot = 0;
		RSItem[] x = Inventory.find(id);
		for(RSItem y : x)
			tot += y.getStack();
		return tot <= amount;
	}

}
