package scripts.ScriptMaker.api.types.intent.object.id;

import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class DistanceToObjectIDLess extends Conditional {

	private static final long serialVersionUID = 1843100445606328648L;
	private int distance;
	private int id;

	public DistanceToObjectIDLess(int id, int distance) {
		this.distance = distance;
		this.id = id;
	}

	@Override
	public boolean run() {
		RSObject[] obs = Objects.findNearest(30, id);
		if (obs.length == 0)
			return false;
		if (Player.getPosition().distanceTo(obs[0]) < distance) {
			return true;
		}
		return false;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "If distance to " + id + " is less than " + distance;
	}

}
