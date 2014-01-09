package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsNotValidNameConditional extends Conditional {

	private static final long serialVersionUID = -547865807639452530L;

	private String name;

	public NPCIsNotValidNameConditional(String name) {
		this.name = name;
	}

	@Override
	public boolean run() {
		return NPCs.find(name).length == 0;
	}

	@Override
	public String toString() {
		return "if NPC " + name + " is not valid";
	}

}
