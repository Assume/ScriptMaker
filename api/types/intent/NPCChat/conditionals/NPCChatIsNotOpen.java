package scripts.ScriptMaker.api.types.intent.NPCChat.conditionals;

import org.tribot.api2007.NPCChat;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCChatIsNotOpen extends Conditional {

	private static final long serialVersionUID = -1023399025416682219L;

	@Override
	public boolean run() {
		return NPCChat.getOptions().length > 0
				|| NPCChat.getClickContinueInterface() != null;
	}

	@Override
	public String toString() {
		return "if NPC Chat is not open ";
	}
}
