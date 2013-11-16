package scripts.ScriptMaker.api.types.intent.object.id;

import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class DistanceToObjectIDConditional extends Conditional
{

	private static final long serialVersionUID = 5458199728714299582L;
	private int distance;
	private int id;

	public DistanceToObjectIDConditional(int id, int distance)
	{
		this.distance = distance;
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSObject[] obs = Objects.findNearest(999, id);
		if (obs.length == 0)
			return false;
		if (Player.getPosition().distanceTo(obs[0]) > distance)
		{
			return true;
		}
		return false;
	}

	public int getDistance()
	{
		return distance;
	}

	public void setDistance(int distance)
	{
		this.distance = distance;
	}

	@Override
	public String toString()
	{
		return "If distance to " + id + " is greater than " + distance;
	}

	
	
	
}