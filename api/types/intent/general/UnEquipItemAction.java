package scripts.ScriptMaker.api.types.intent.general;

import scripts.ScriptMaker.api.types.enums.Equipment;
import scripts.ScriptMaker.api.types.main.Action;

public class UnEquipItemAction extends Action
{

	private static final long serialVersionUID = 2080911635018566179L;

	private Equipment.Gear g;

	public UnEquipItemAction(Equipment.Gear g)
	{
		this.g = g;
	}

	@Override
	public boolean run()
	{
		Equipment.unequip(g);
		return true;
	}

	@Override
	public String toString()
	{
		return "Unequip gear in slot" + g.name();
	}

}
