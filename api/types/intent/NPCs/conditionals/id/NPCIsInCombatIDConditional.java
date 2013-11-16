package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsInCombatIDConditional extends Conditional
{

	private static final long serialVersionUID = -7430488358574599014L;
	
	private int id;

	public NPCIsInCombatIDConditional(int id)
	{
		this.id = id;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.findNearest(id).length == 0) return false;
		 return NPCs.findNearest(id)[0].isInCombat();
	}
	
	@Override
	public String toString()
	{
		return "if NPC "+id+" is in combat";
	}
	
}
