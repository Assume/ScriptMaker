package scripts.ScriptMaker.api.types.intent.worldhopping;

import scripts.ScriptMaker.api.methods.IngameWorldSwitcher;
import scripts.ScriptMaker.api.types.main.Action;

public class HopToWorldAction extends Action {

	private static final long serialVersionUID = -3553112815055918249L;

	private int world;

	public HopToWorldAction(int world) {
		this.world = world;
	}

	@Override
	public boolean run() {
		return IngameWorldSwitcher.switchWorld(world);
	}

	@Override
	public String toString() {
		return "hop to world " + world;
	}

}
