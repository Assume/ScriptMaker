package scripts.ScriptMaker.api.types.intent.worldhopping;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.main.vars;

public class HopToRandomWorldAction extends Action
{

    private static final long serialVersionUID = 311583192264720913L;

    @Override
    public boolean run()
    {
	return vars.world.hop(-1);
    }

    
    @Override
    public String toString()
    {
	return "Hop to random world";
    }
}
