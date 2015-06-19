package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Conditional;

public class DistanceToNearestNPCIsGreaterThanIDConditional extends Conditional
{

	private static final long serialVersionUID = 5519027287226216282L;
	
	private int id;
	private int distance;
	
	public DistanceToNearestNPCIsGreaterThanIDConditional(int id, int distance)
	{
		this.id = id;
		this.distance = distance;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.find(id).length == 0) return false;
		if(NPCs.findNearest(id)[0].getPosition().distanceTo(Player.getPosition()) > distance) return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return "if distance to nearest "+id+ " NPC is greater than "+distance;
	}
	
}
