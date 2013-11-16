package scripts.ScriptMaker.api.types.intent.NPCs.actions.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class TurnCameraToNPCIDAction extends Action
{

	private static final long serialVersionUID = 5574606946440670648L;

	private int id;

	public TurnCameraToNPCIDAction(int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSNPC[] npcs = NPCs.findNearest(id);
		if (npcs.length == 0)
			return false;
		DefaultMethods.turnTo(npcs[0]);
		return true;
	}

	@Override
	public String toString()
	{
		return "turn camera to the nearest " + id;
	}
	
}
