package scripts.ScriptMaker.api.types.intent.interfaces.conditionals;

import org.tribot.api2007.Interfaces;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InterfaceIsClosedConditional extends Conditional
{

    private static final long serialVersionUID = 8567240906715042918L;

    private int parent;

    public InterfaceIsClosedConditional(final int parent)
    {
	this.parent = parent;
    }

    @Override
    public boolean run()
    {
	return !Interfaces.isInterfaceValid(parent);
    }
    
    @Override
    public String toString()
    {
	return "if "+parent+" is closed";
    }

}
