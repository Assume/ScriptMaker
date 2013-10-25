package scripts.ScriptMaker.api.types.intent.conditionals;

import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.generic.RSArea;
import scripts.ScriptMaker.api.types.main.Conditional;

public class AreaContainsPlayerConditional extends Conditional
{

	private static final long serialVersionUID = -5468426669656288530L;

	private RSArea area;
	
	public AreaContainsPlayerConditional(int northEastX, int northEastY, int southWestX, int southWestY)
	{
		this.area = new RSArea(southWestX, southWestY, northEastX, northEastY);
	}
	
	@Override
	public boolean run()
	{
		return area.contains(Player.getPosition());
	}
	
	@Override
	public String toString()
	{
		return "if player is in area";
	}

}
