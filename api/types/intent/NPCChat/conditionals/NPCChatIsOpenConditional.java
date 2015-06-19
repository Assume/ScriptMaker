package scripts.ScriptMaker.api.types.intent.NPCChat.conditionals;

import java.io.Serializable;

import org.tribot.api2007.NPCChat;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCChatIsOpenConditional extends Conditional implements
		Serializable {

	private static final long serialVersionUID = -1932790746609552578L;

	@Override
	public boolean run() {
		return NPCChat.getOptions() != null
				|| NPCChat.getClickContinueInterface() != null;
	}

	@Override
	public String toString() {
		return "if NPC Chat is open ";
	}

}
