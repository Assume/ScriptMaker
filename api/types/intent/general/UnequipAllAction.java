package scripts.ScriptMaker.api.types.intent.general;

import java.io.Serializable;

import scripts.ScriptMaker.api.types.enums.Equipment;
import scripts.ScriptMaker.api.types.main.Action;

public class UnequipAllAction extends Action implements Serializable
{

	private static final long serialVersionUID = -1135976549995417539L;

	@Override
	public boolean run()
	{
		Equipment.unequipAll();
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Unequip all gear";
	}

}
