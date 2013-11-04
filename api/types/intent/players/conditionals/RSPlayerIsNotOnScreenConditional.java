package scripts.ScriptMaker.api.types.intent.players.conditionals;

import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;

import scripts.ScriptMaker.api.types.main.Conditional;

public class RSPlayerIsNotOnScreenConditional extends Conditional
{

    private static final long serialVersionUID = -7573181977592822858L;

    private String name;

    public RSPlayerIsNotOnScreenConditional(String name)
    {
	this.name = name;
    }

    @Override
    public boolean run()
    {
	RSPlayer[] players = Players.find(name);
	if (players.length == 0)
	    return true;
	return !players[0].isOnScreen();

    }
    
    @Override
    public String toString()
    {
	return "if "+name+" is on screen";
    }
}
