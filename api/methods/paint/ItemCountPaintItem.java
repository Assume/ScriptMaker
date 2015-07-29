package scripts.ScriptMaker.api.methods.paint;

import java.awt.Color;
import java.io.Serializable;

import org.tribot.api2007.Inventory;

import scripts.ScriptMaker.api.types.main.PaintItem;

public class ItemCountPaintItem extends PaintItem implements Serializable {

	private static final long serialVersionUID = 3506224859497273503L;
	private int count;
	private int id;

	public ItemCountPaintItem(Color border, Color inside, String name,
			String displayText, int id) {
		super(border, inside, name, displayText);
		this.id = id;
		this.count = 0;
	}

	@Override
	public void updateData() {
		count += Inventory.getCount(id);
		super.setFull(super.getDefaultFull() + count);
	}

	@Override
	public String toString() {
		return "Item Counter";
	}

	@Override
	public void init() {
		super.setFull(super.getDefaultFull() + count);
	}

	@Override
	public void clearAll() {
		count = 0;
	}

	@Override
	public String[] values() {
		return new String[] { count + " " + id };
	}

}
