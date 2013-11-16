package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCHPPercentIsLessThanIDConditional extends Conditional
{


	private static final long serialVersionUID = 3447227860937648137L;
	
	private int id;
	private int percent;

	public NPCHPPercentIsLessThanIDConditional(int id, int percent)
	{
		this.id = id;
		this.percent = percent;
	}

	@Override
	public boolean run()
	{
		if (NPCs.find(id).length == 0)
			return false;
		RSNPC[] np = NPCs.findNearest(id);
		return ((np[0].getHealth() / np[0].getMaxHealth()) * 100) < percent;
	}

	@Override
	public String toString()
	{
		return "if nearest NPC " + id + " HP percent is < " + percent;
	}

}
