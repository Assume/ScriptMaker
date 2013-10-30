package scripts.ScriptMaker.api.types.intent.NPCs.conditionals;

import java.io.Serializable;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsOnScreenConditional extends Conditional implements Serializable
{
	
	private static final long serialVersionUID = -435831098606456531L;

	private String name;
	
	public NPCIsOnScreenConditional(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.find(name).length == 0) return false;
		if(NPCs.findNearest(name)[0].isOnScreen()) return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return "if nearest "+name+ " is on screen";
	}

}
