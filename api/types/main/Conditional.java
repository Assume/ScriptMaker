package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;

public abstract class Conditional implements Serializable
{

    private static final long serialVersionUID = -3326120915885350552L;

    public Conditional()
    {

    }

    public abstract boolean run();

}
