package scripts.ScriptMaker.api.types.intent.players.actions;

import org.tribot.api.DynamicClicking;
import org.tribot.api2007.Player;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSPlayer;

import scripts.ScriptMaker.api.types.main.Action;

public class ClickNearestPlayerWithAction extends Action
{

    private static final long serialVersionUID = 2594996431061021536L;

    private String action;

    public ClickNearestPlayerWithAction(String action)
    {
	this.action = action;
    }

    @Override
    public boolean run()
    {
	RSPlayer[] players = Players.getAll();
	if (players.length == 0)
	    return false;
	return DynamicClicking.clickRSModel(Players.sortByDistance(
		Player.getPosition(), players)[0].getModel(), action);
    }

    @Override
    public String toString()
    {
	return "click nearest player with the action "+action;
    }
    
}
