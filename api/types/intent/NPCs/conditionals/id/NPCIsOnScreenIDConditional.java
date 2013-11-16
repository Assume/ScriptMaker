package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsOnScreenIDConditional extends Conditional
{

	private static final long serialVersionUID = 1323312787801865731L;

	private int id;

	public NPCIsOnScreenIDConditional(int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		if (NPCs.find(id).length == 0)
			return false;
		if (NPCs.findNearest(id)[0].isOnScreen())
			return true;
		return false;
	}

	@Override
	public String toString()
	{
		return "if nearest " + id + " is on screen";
	}

}
