package scripts.ScriptMaker.api.types.intent.object;

import org.tribot.api2007.Objects;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsValidIDConditional extends Conditional
{

	private static final long serialVersionUID = 8044707997280738840L;

	private int id;

	public ObjectIsValidIDConditional(int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		return Objects.find(999, id).length > 0;
	}

	@Override
	public String toString()
	{
		return "If " + id + " is valid ";
	}
}
