package scripts.ScriptMaker.api.types.intent.NPCChat.conditionals;

import org.tribot.api2007.NPCChat;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCChatIsOpenConditional extends Conditional
{

	private static final long serialVersionUID = -1932790746609552578L;

	@Override
	public boolean run()
	{
		return NPCChat.getOptions().length > 0 || NPCChat.getClickContinueInterface() != null;
	}
	
	@Override
	public String toString()
	{
		return "if NPC Chat is open ";
	}

}
