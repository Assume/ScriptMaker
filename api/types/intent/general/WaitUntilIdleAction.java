package scripts.ScriptMaker.api.types.intent.general;

import java.io.Serializable;

import org.tribot.api.General;
import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Action;

public class WaitUntilIdleAction extends Action implements Serializable {

	private static final long serialVersionUID = -2499915370394207922L;

	public WaitUntilIdleAction() {

	}

	@Override
	public boolean run() {
		while (Player.getAnimation() != -1)
			General.sleep(100);
		return true;
	}

	@Override
	public String toString() {
		return "wait until idle";
	}

}
