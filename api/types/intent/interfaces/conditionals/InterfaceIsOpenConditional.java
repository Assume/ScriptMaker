package scripts.ScriptMaker.api.types.intent.interfaces.conditionals;

import org.tribot.api2007.Interfaces;

import scripts.ScriptMaker.api.types.main.Conditional;

public class InterfaceIsOpenConditional extends Conditional
{

    private static final long serialVersionUID = 992335999326424458L;

    private int parent;

    public InterfaceIsOpenConditional(int parent)
    {
	this.parent = parent;
    }

    @Override
    public boolean run()
    {
	return Interfaces.isInterfaceValid(parent);
    }

}
