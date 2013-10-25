package scripts.ScriptMaker.api.types.wrappers;

import java.io.Serializable;

import org.tribot.api2007.types.RSTile;

public class TileWrapper extends RSTile implements Serializable
{

    private static final long serialVersionUID = 19981017L;

    public TileWrapper()
    {
	super(0, 0);
    }

    public TileWrapper(int arg0, int arg1)
    {
	super(arg0, arg1);

    }

}
