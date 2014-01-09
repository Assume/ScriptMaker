package scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals;

import org.tribot.api2007.Combat;
import org.tribot.api2007.types.RSCharacter;
import org.tribot.api2007.types.RSPlayer;

import scripts.ScriptMaker.api.types.main.Conditional;

public class IsBeingAttackedByPlayerConditional extends Conditional {

	private static final long serialVersionUID = 1282422890186231795L;

	@Override
	public boolean run() {
		for (RSCharacter s : Combat.getAttackingEntities()) {
			if (s instanceof RSPlayer)
				return true;
		}
		return false;
	}

}
