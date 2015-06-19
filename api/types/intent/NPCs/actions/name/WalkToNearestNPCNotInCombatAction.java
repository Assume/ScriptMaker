package scripts.ScriptMaker.api.types.intent.NPCs.actions.name;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Action;

public class WalkToNearestNPCNotInCombatAction extends Action {

	private static final long serialVersionUID = 8518027099724465013L;

	private String name;

	public WalkToNearestNPCNotInCombatAction(String name) {
		this.name = name;
	}

	@Override
	public boolean run() {
		RSNPC[] npcs = NPCs.findNearest(name);
		if (npcs.length == 0)
			return false;
		RSNPC good = null;
		for (RSNPC p : npcs)
			if (!p.isInCombat()) {
				good = p;
				break;
			}
		Walking.blindWalkTo(good);
		return true;
	}

	@Override
	public String toString() {
		return "walk to the nearest NPC (not in combat) " + name;
	}
}
