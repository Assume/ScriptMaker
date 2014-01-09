package scripts.ScriptMaker.api.types.intent.conditionals;

import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.generic.RSArea;
import scripts.ScriptMaker.api.types.main.Conditional;

public class AreaDoesntContainPlayerConditional extends Conditional {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7553141798187924860L;
	private RSArea area;

	public AreaDoesntContainPlayerConditional(int northEastX, int northEastY,
			int southWestX, int southWestY) {
		this.area = new RSArea(southWestX, southWestY, northEastX, northEastY);
	}

	@Override
	public boolean run() {
		return !area.contains(Player.getPosition());
	}

	@Override
	public String toString() {
		return "if player is not in area";
	}
}
