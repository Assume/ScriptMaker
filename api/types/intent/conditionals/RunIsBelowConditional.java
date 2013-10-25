package scripts.ScriptMaker.api.types.intent.conditionals;

import org.tribot.api2007.Game;

import scripts.ScriptMaker.api.types.main.Conditional;

public class RunIsBelowConditional extends Conditional
{

	private static final long serialVersionUID = 6549656485344855655L;

	private int percent;

	public RunIsBelowConditional(int percent)
	{
		this.percent = percent;
	}

	@Override
	public boolean run()
	{
		return Game.getRunEnergy() < percent;
	}

	@Override
	public String toString()
	{
		return "If run energy is below "+percent;
	}
	
}
