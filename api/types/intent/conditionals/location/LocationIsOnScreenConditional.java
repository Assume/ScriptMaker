package scripts.ScriptMaker.api.types.intent.conditionals.location;

import scripts.ScriptMaker.api.types.main.Conditional;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class LocationIsOnScreenConditional extends Conditional
{

	private static final long serialVersionUID = 1735929358962245255L;

	private int x;
	private int y;

	public LocationIsOnScreenConditional(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean run()
	{
		return new CustomTile(x,y).toTileWrapper().isOnScreen();
	}

}
