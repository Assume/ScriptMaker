package scripts.ScriptMaker.api.types.intent.worldhopping;

import org.tribot.api2007.WorldHopper;

import scripts.ScriptMaker.api.types.main.Action;

public class HopToRandomWorldAction extends Action {

	private static final long serialVersionUID = 311583192264720913L;

	@Override
	public boolean run() {
		return WorldHopper.changeWorld(WorldHopper.getRandomWorld(true));
	}

	@Override
	public String toString() {
		return "Hop to random world";
	}
}
