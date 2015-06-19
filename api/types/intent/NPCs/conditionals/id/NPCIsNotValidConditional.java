package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCIsNotValidConditional extends Conditional {

	private static final long serialVersionUID = 7766567708712564313L;

	private int id;

	public NPCIsNotValidConditional(int id) {
		this.id = id;
	}

	@Override
	public boolean run() {
		return NPCs.find(id).length == 0;
	}

	@Override
	public String toString() {
		return "if NPC "+id+" is not valid";
	}

}
