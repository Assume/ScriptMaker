package scripts.ScriptMaker.api.types.intent.grounditems.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Camera;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.types.RSGroundItem;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;

import scripts.ScriptMaker.api.types.main.Action;

public class LootAllItemsAction extends Action implements Serializable {

	private static final long serialVersionUID = -8400457127085801386L;

	private int[] id;

	public LootAllItemsAction(Integer[] integer) {
		this.id = convert(integer);
	}

	private int[] convert(Integer[] ids) {
		int[] temp = new int[ids.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = ids[i];
		}

		return temp;

	}

	@Override
	public boolean run() {
		loot(getLootableItems(id));
		return true;
	}

	@Override
	public String toString() {
		StringBuilder i = new StringBuilder();
		for (int x : id) {
			i.append(x + " ");
		}
		return "loot all items with the ids: " + i.toString();
	}

	private void loot(RSGroundItem[] items) {
		for (RSGroundItem x : items) {
			if (Inventory.isFull())
				break;
			if (!x.isOnScreen())
				Camera.turnToTile(x.getPosition());
			String name = getRSGroundItemName(x);
			if (name == null)
				continue;
			final int total_items_in_inventory = getTotalInventoryCount();
			Clicking.click("Take " + name, x);
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return getTotalInventoryCount() != total_items_in_inventory;
				}
			}, General.random(2000, 3000));
			General.sleep(250, 450);
		}
	}

	private String getRSGroundItemName(RSGroundItem x) {
		RSItemDefinition def = x.getDefinition();
		if (def == null)
			return null;
		return def.getName();
	}

	private RSGroundItem[] getLootableItems(int... ids) {
		RSGroundItem[] items = GroundItems.findNearest(ids);
		List<RSGroundItem> list = new ArrayList<RSGroundItem>();
		for (RSGroundItem x : items) {
			if (!PathFinding.canReach(x, false))
				continue;
			list.add(x);
		}
		return list.toArray(list.toArray(new RSGroundItem[list.size()]));
	}

	private int getTotalInventoryCount() {
		int tot = 0;
		RSItem[] items = Inventory.getAll();
		for (RSItem x : items)
			tot += x.getStack();
		return tot;
	}

}
