package scripts.ScriptMaker.api.types.intent.object;

import java.io.Serializable;

import org.tribot.api2007.Objects;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsValidConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = -3730664171654740373L;

	private String name;
	
	public ObjectIsValidConditional(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		return Objects.find(999, name).length > 0;
	}
	
	@Override
	public String toString()
	{
		return "If "+name+" is valid ";
	}

}
