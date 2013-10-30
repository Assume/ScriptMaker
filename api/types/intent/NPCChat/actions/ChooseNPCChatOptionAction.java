package scripts.ScriptMaker.api.types.intent.NPCChat.actions;

import java.io.Serializable;

import org.tribot.api2007.NPCChat;

import scripts.ScriptMaker.api.types.main.Action;

public class ChooseNPCChatOptionAction extends Action implements Serializable
{

	private static final long serialVersionUID = 8054067609944861874L;
	private String option;

	public ChooseNPCChatOptionAction(String option)
	{
		this.option = option;
	}

	@Override
	public boolean run()
	{
		return NPCChat.selectOption(option, true);
	}

	
	@Override
	public String toString()
	{
		return "choose NPC Chat option "+option;
	}
}
