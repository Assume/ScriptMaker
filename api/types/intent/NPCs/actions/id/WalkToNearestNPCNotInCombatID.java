package scripts.ScriptMaker.api.types.intent.NPCs.actions.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Action;

public class WalkToNearestNPCNotInCombatID extends Action {

	private static final long serialVersionUID = -7439350248889596808L;
	
	private int id;

	public WalkToNearestNPCNotInCombatID(int id) {
		this.id = id;
	}

	@Override
	public boolean run() {
		RSNPC[] npcs = NPCs.findNearest(id);
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
		return "walk to the nearest NPC (not in combat) " + id;
	}
}
