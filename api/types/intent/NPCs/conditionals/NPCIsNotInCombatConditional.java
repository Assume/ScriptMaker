package scripts.ScriptMaker.api.types.intent.NPCs.conditionals;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsNotInCombatConditional extends Conditional
{
	
	private static final long serialVersionUID = 32348679553731035L;
	
	private String name;

	public NPCIsNotInCombatConditional(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.findNearest(name).length == 0) return false;
		 return !NPCs.findNearest(name)[0].isInCombat();
	}
	
	@Override
	public String toString()
	{
		return "if NPC "+name+" is not in combat";
	}

}
