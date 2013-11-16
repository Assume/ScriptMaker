package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsNotInCombatIDConditional extends Conditional
{

	private static final long serialVersionUID = 3643674010277445272L;

	private int id;

	public NPCIsNotInCombatIDConditional(int id)
	{
		this.id = id;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.findNearest(id).length == 0) return false;
		 return !NPCs.findNearest(id)[0].isInCombat();
	}
	
	@Override
	public String toString()
	{
		return "if NPC "+id+" is not in combat";
	}

}
