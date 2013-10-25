package scripts.ScriptMaker.api.types.intent.NPCChat.actions;

import org.tribot.api2007.NPCChat;

import scripts.ScriptMaker.api.types.main.Action;

public class ClickToContinueAction extends Action
{

	private static final long serialVersionUID = 8570185114111783216L;

	@Override
	public boolean run()
	{
		return NPCChat.clickContinue(true);
	}
	
	@Override
	public String toString()
	{
		return "click to continue";
	}

}
