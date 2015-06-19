package scripts.ScriptMaker.api.types.intent.inventory.actions;

import java.util.Arrays;
import java.util.List;

import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;

import scripts.ScriptMaker.api.types.main.Action;

public class ClickFirstItemMultipleAction extends Action {

	private static final long serialVersionUID = 112398128319283L;
	private Integer[] ids;
	private List<Integer> list;
	private String action;

	public ClickFirstItemMultipleAction(Integer[] integers, String action) {
		this.ids = integers;
		this.action = action;
		list = Arrays.asList(ids);
	}

	@Override
	public boolean run() {
		RSItem[] item = Inventory.find((new Filter<RSItem>() {
			@Override
			public boolean accept(RSItem arg0) {
				return list.contains(arg0.getID());
			}
		}));
		if (item.length == 0)
			return false;
		return item[0].click(action);

	}

	@Override
	public String toString() {
		return "click the first of " + ids + " with the action: " + action;
	}

}
