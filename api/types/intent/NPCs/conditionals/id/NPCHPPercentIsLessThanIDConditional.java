package scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id;

import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.ScriptMaker.api.types.main.Conditional;

public class NPCHPPercentIsLessThanIDConditional extends Conditional {

	private static final long serialVersionUID = 3447227860937648137L;

	private int id;
	private int percent;

	public NPCHPPercentIsLessThanIDConditional(int id, int percent) {
		this.id = id;
		this.percent = percent;
	}

	@Override
	public boolean run() {
		RSNPC[] np = NPCs.findNearest(id);
		if (np.length == 0)
			return false;
		double x = np[0].getHealth();
		double y = np[0].getMaxHealth();

		return ((x / y) * 100) < percent;
	}

	@Override
	public String toString() {
		return "if nearest NPC " + id + " HP percent is < " + percent;
	}

}
