package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name;

import java.io.Serializable;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Conditional;

public class DistanceToNearestNPCIsGreaterThanConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 219045661373186061L;

	private String name;
	private int distance;
	
	public DistanceToNearestNPCIsGreaterThanConditional(String name, int distance)
	{
		this.name = name;
		this.distance = distance;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.find(name).length == 0) return false;
		if(NPCs.findNearest(name)[0].getPosition().distanceTo(Player.getPosition()) > distance) return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return "if distance to nearest "+name + " NPC is greater than "+distance;
	}

}
