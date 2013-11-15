package scripts.ScriptMaker.api.types.intent.object;

import org.tribot.api2007.Objects;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsNotValidConditional extends Conditional
{

    private static final long serialVersionUID = -3384879990427308950L;

    private String name;
    
    public ObjectIsNotValidConditional(String name)
    {
    	this.name = name;
    }
    
    @Override
    public boolean run()
    {
    	return Objects.findNearest(999, name).length == 0;
    }

    @Override
    public String toString()
    {
    	return "if " + name +" is not valid";
    }
    
}
