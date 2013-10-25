package scripts.ScriptMaker.api.types.intent.NPCs.conditionals;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCHPPercentIsLessThanConditional extends Conditional
{

	private static final long serialVersionUID = -1766256992141517498L;

	private String name;
	private int percent;
	
	public NPCHPPercentIsLessThanConditional(String name, int percent)
	{
		this.name = name;
		this.percent = percent;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.find(name).length == 0) return false;
		RSNPC[] np = NPCs.findNearest(name);
		return ((np[0].getHealth() / np[0].getMaxHealth()) * 100) < percent;
	}

	@Override
	public String toString()
	{
		return "if nearest NPC "+name+" HP percent is < " +percent;
	}
	
}
