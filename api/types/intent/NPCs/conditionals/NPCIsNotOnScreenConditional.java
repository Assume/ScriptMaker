package scripts.ScriptMaker.api.types.intent.NPCs.conditionals;

import java.io.Serializable;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsNotOnScreenConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 4248957667607165067L;
	
	private String name;
	
	public NPCIsNotOnScreenConditional(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		if(NPCs.find(name).length == 0) return true;
		if(NPCs.findNearest(name)[0].isOnScreen()) return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "if nearest "+name+ " is not on screen";
	}
	
}
