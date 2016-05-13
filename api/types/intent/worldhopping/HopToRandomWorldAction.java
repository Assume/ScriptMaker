package scripts.ScriptMaker.api.types.intent.worldhopping;

import scripts.ScriptMaker.api.methods.IngameWorldSwitcher;
import scripts.ScriptMaker.api.types.main.Action;

public class HopToRandomWorldAction extends Action {

	private static final long serialVersionUID = 311583192264720913L;

	@Override
	public boolean run() {
		return IngameWorldSwitcher.switchToRandomWorld();
	}

	@Override
	public String toString() {
		return "Hop to random world";
	}
}
