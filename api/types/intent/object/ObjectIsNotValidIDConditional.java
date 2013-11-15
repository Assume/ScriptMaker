package scripts.ScriptMaker.api.types.intent.object;

import org.tribot.api2007.Objects;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsNotValidIDConditional extends Conditional
{

	private static final long serialVersionUID = 2002392028565162594L;
	
	private int id;

	public ObjectIsNotValidIDConditional(int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		return Objects.findNearest(999, id).length == 0;
	}
	
	@Override
    public String toString()
    {
    	return "if " + id +" is not valid";
    }

}
