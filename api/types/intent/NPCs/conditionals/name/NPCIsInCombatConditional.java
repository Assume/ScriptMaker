package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name;

import java.io.Serializable;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsInCombatConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 4724883745301565203L;

	private String name;

	public NPCIsInCombatConditional(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.findNearest(name).length == 0) return false;
		 return NPCs.findNearest(name)[0].isInCombat();
	}
	
	@Override
	public String toString()
	{
		return "if NPC "+name+" is in combat";
	}

}
