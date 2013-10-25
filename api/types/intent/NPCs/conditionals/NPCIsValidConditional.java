package scripts.ScriptMaker.api.types.intent.NPCs.conditionals;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsValidConditional extends Conditional
{

	private static final long serialVersionUID = -6010965928417284637L;

	private String name;
	
	public NPCIsValidConditional(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		return NPCs.find(name).length > 0;
	} 
	
	@Override
	public String toString()
	{
		return "if nearest NPC "+name+ " exists";
					
	}

}
