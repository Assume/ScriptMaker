package scripts.ScriptMaker.api.types.intent.interfaces.conditionals;

import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InterfaceIsHiddenConditional extends Conditional {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1064238445610356730L;
	private int parent;

	public InterfaceIsHiddenConditional(final int parent) {
		this.parent = parent;
	}

	@Override
	public boolean run() {
		RSInterface x = Interfaces.get(parent);

		return x == null || x.isHidden();
	}

	@Override
	public String toString() {
		return "if " + parent + " is hidden";
	}

}
