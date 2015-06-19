package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name;

import java.io.Serializable;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCHPPercentIsLessThanConditional extends Conditional implements
		Serializable {

	private static final long serialVersionUID = -1766256992141517498L;

	private String name;
	private int percent;

	public NPCHPPercentIsLessThanConditional(String name, int percent) {
		this.name = name;
		this.percent = percent;
	}

	@Override
	public boolean run() {
		RSNPC[] np = NPCs.findNearest(name);
		if (np.length == 0)
			return false;
		double x = np[0].getHealth();
		double y = np[0].getMaxHealth();

		return ((x / y) * 100) < percent;
	}

	@Override
	public String toString() {
		return "if nearest NPC " + name + " HP percent is < " + percent;
	}

}
