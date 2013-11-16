package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsNotOnScreenIDConditional extends Conditional
{

	private static final long serialVersionUID = -8586718101984114779L;

	private int id;

	public NPCIsNotOnScreenIDConditional(int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		if (NPCs.find(id).length == 0)
			return true;
		if (NPCs.findNearest(id)[0].isOnScreen())
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "if nearest " + id + " is not on screen";
	}

}
