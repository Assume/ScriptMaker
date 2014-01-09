package scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals;

import org.tribot.api2007.Equipment;

import scripts.ScriptMaker.api.types.main.Conditional;

public class IsItemEquippedConditional extends Conditional {

	private static final long serialVersionUID = 371559445378273663L;

	private int id;

	public IsItemEquippedConditional(int id) {
		this.id = id;
	}

	@Override
	public boolean run() {
		return Equipment.isEquipped(id);
	}

}
