package scripts.ScriptMaker.api.types.intent.NPCs.actions;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class TurnCameraToNPCAction extends Action
{

	private static final long serialVersionUID = -1868462594046822295L;

	private String name;

	public TurnCameraToNPCAction(String name)
	{
		this.name = name;
	}

	@Override
	public boolean run()
	{
		RSNPC[] npcs = NPCs.findNearest(name);
		if (npcs.length == 0)
			return false;
		DefaultMethods.turnTo(npcs[0]);
		return true;
	}

	@Override
	public String toString()
	{
		return "turn camera to the nearest " + name;
	}

}
