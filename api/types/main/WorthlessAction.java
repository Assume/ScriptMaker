package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;

public class WorthlessAction extends Action implements Serializable
{

    private static final long serialVersionUID = -725595669109589198L;

    @Override
    public boolean run()
    {
	return false;
    }

}
