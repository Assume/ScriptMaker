package scripts.ScriptMaker.api.types.intent.object.name;

import java.io.Serializable;

import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class DistanceToObjectIsGreaterThanConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 5880035586303567515L;

	private int distance;
	private String name;

	public DistanceToObjectIsGreaterThanConditional(String name, int distance)
	{
		this.distance = distance;
		this.name = name;
	}



	@Override
	public boolean run()
	{
		RSObject[] obs = Objects.findNearest(999, name);
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "If distance to " + name + " is greater than " + distance;
	}

}
