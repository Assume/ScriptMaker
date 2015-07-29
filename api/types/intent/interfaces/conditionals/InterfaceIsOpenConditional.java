package scripts.ScriptMaker.api.types.intent.interfaces.conditionals;

import java.io.Serializable;

import org.tribot.api2007.Interfaces;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InterfaceIsOpenConditional extends Conditional implements
		Serializable {

	private static final long serialVersionUID = 992335999326424458L;

	private int parent;

	public InterfaceIsOpenConditional(int parent) {
		this.parent = parent;
	}

	@Override
	public boolean run() {
		return Interfaces.isInterfaceValid(parent);
	}

	@Override
	public String toString() {
		return "if " + parent + " is open";
	}

}
