package scripts.ScriptMaker.api.types.intent.conditionals.skills;

import java.io.Serializable;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Conditional;

public class HPIsLessThanConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 799589518423125329L;

	private int percent;
	
	public HPIsLessThanConditional(final int percent)
	{
		this.percent = percent;
	}
	
	@Override
	public boolean run()
	{
		return  DefaultMethods.getHPPercent() < percent;
	}
	
	@Override
	public String toString()
	{
		return "if HP percent < "+percent;
	}

}
