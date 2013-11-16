package scripts.ScriptMaker.api.types.intent.NPCs.actions.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Action;

public class WalkToNearestNPCIDAction extends Action
{

	private static final long serialVersionUID = -8201666542759748656L;

	private int id;
	
	public WalkToNearestNPCIDAction(int id)
	{
		this.id = id;
	}
	
	@Override
	public boolean run()
	{
		RSNPC[] npcs = NPCs.findNearest(id);
		if(npcs.length == 0) return false;
		Walking.blindWalkTo(npcs[0]);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "walk to the nearest NPC "+id;
	}
	
}
