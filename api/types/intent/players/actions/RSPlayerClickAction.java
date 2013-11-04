package scripts.ScriptMaker.api.types.intent.players.actions;

import org.tribot.api.DynamicClicking;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;

import scripts.ScriptMaker.api.types.main.Action;

public class RSPlayerClickAction extends Action
{

    private static final long serialVersionUID = 2328865209783022252L;

    private String name;
    private String action;

    public RSPlayerClickAction(String name, String action)
    {
	this.name = name;
	this.action = action;
    }

    @Override
    public boolean run()
    {
	RSPlayer[] players = Players.find(name);
	if (players.length == 0)
	    return false;
	return DynamicClicking.clickRSModel(players[0].getModel(), action);
    }
    
    @Override
    public String toString()
    {
	return "click "+name+" with the action "+action;
    }

}
