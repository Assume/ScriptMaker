package scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals;

import java.io.Serializable;

import org.tribot.api2007.Combat;

import scripts.ScriptMaker.api.types.main.Conditional;

public class PlayerIsNotInCombatConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 9156292687711151952L;

	@Override
	public boolean run()
	{
	    return Combat.getAttackingEntities().length == 0;
	}

	
	@Override
	public String toString()
	{
		return "if player is not in combat";
	}
}
