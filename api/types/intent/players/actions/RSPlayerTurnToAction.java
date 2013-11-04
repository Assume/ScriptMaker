package scripts.ScriptMaker.api.types.intent.players.actions;

import org.tribot.api2007.Camera;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;

import scripts.ScriptMaker.api.types.main.Action;

public class RSPlayerTurnToAction extends Action
{

    private static final long serialVersionUID = -7043918999700607705L;

    private String name;

    public RSPlayerTurnToAction(String name)
    {
	this.name = name;
    }

    @Override
    public boolean run()
    {
	RSPlayer[] players = Players.find(name);
	if(players.length == 0)
	    return false;
	Camera.turnToTile(players[0]);
	return true;
    }

    @Override
    public String toString()
    {
	return "turn to "+name;
    }
    
}
