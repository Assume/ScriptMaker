package scripts.ScriptMaker.api.types.intent.inventory.actions;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class DropAllExceptMultipleAction extends Action {

	private static final long serialVersionUID = -9101455173327969031L;

	private int[] ints;

	public DropAllExceptMultipleAction(Integer... integers) {
		this.ints = DefaultMethods.convertIntegerToInt(integers);
	}

	@Override
	public boolean run() {
		Inventory.dropAllExcept(ints);
		return true;
	}

}
