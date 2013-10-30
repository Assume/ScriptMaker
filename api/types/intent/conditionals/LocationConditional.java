package scripts.ScriptMaker.api.types.intent.conditionals;

import java.io.Serializable;

import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.ScriptMaker.api.types.main.Conditional;

public class LocationConditional extends Conditional implements Serializable
{

    private static final long serialVersionUID = -6902617622802866256L;

    private RSTile tile;
    private int distance;

    public LocationConditional(RSTile tile, final int distance)
    {
	this.tile = tile;
    }

    @Override
    public boolean run()
    {
	return Player.getPosition().distanceTo(tile) < distance;
    }

    @Override
    public String toString()
    {
	return "If distance to " + tile + " < " + "distance";
    }

}
