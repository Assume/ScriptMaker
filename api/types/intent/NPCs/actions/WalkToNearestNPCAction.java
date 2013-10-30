package scripts.ScriptMaker.api.types.intent.NPCs.actions;

import java.io.Serializable;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Action;

public class WalkToNearestNPCAction extends Action implements Serializable
{

	private static final long serialVersionUID = 5900341783288079788L;
	
	private String name;
	
	public WalkToNearestNPCAction(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		RSNPC[] npcs = NPCs.findNearest(name);
		if(npcs.length == 0) return false;
		Walking.blindWalkTo(npcs[0]);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "walk to the nearest NPC "+name;
	}
}
