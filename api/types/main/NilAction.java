package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;

public class NilAction extends Action implements Serializable
{

    private static final long serialVersionUID = 7843041022135606309L;

    @Override
    public boolean run()
    {

	return false;
    }

    @Override
    public String toString()
    {
	return "";
    }

}
