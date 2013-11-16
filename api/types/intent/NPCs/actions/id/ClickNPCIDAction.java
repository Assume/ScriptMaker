package scripts.ScriptMaker.api.types.intent.NPCs.actions.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class ClickNPCIDAction extends Action
{

	private static final long serialVersionUID = 4003815579636801954L;
	
	private int id;
	private String action;
	
	public ClickNPCIDAction(int id, String action)
	{
		this.id = id;
		this.action = action;
	}
	
	@Override
	public boolean run()
	{
		RSNPC[] npcs = NPCs.findNearest(id);
		if(npcs.length == 0) return false;
		DefaultMethods.click(npcs[0], action);
		return true;
	}

	@Override
	public String toString()
	{
		return "click the nearest "+id+" with the action "+action;
	}
	
}
