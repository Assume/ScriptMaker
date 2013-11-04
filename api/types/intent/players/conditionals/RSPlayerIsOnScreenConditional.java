package scripts.ScriptMaker.api.types.intent.players.conditionals;

import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;

import scripts.ScriptMaker.api.types.main.Conditional;

public class RSPlayerIsOnScreenConditional extends Conditional
{

    private static final long serialVersionUID = -988701723350385215L;

    private String name;
    
    public RSPlayerIsOnScreenConditional(String name)
    {
	this.name = name;
    }
    
    @Override
    public boolean run()
    {
	RSPlayer[] players = Players.find(name);
	if(players.length == 0)
	    return false;
	if(players[0].isOnScreen())
	    return true;
	return false;
    }

    @Override
    public String toString()
    {
	return "if "+name+" is not on screen";
    }
    
}
