package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsValidIDConditional extends Conditional
{

	private static final long serialVersionUID = 190459572100896262L;

	private int id;

	public NPCIsValidIDConditional(int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		return NPCs.find(id).length > 0;
	}

	@Override
	public String toString()
	{
		return "if nearest NPC " + id + " exists";

	}

}
