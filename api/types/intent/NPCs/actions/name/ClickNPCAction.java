package scripts.ScriptMaker.api.types.intent.NPCs.actions.name;

import java.io.Serializable;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class ClickNPCAction extends Action implements Serializable
{

	private static final long serialVersionUID = 5397408705386141584L;

	private String name;
	private String action;
	
	public ClickNPCAction(String name, String action)
	{
		this.name = name;
		this.action = action;
	}
	
	@Override
	public boolean run()
	{
		RSNPC[] npcs = NPCs.findNearest(name);
		if(npcs.length == 0) return false;
		DefaultMethods.click(npcs[0], action);
		return true;
	}

	@Override
	public String toString()
	{
		return "click the nearest "+name+" with the action "+action;
	}
	
}
