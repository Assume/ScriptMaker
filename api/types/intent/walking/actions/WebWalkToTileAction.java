package scripts.ScriptMaker.api.types.intent.walking.actions;

import java.io.Serializable;

import org.tribot.api2007.WebWalking;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class WebWalkToTileAction extends Action implements Serializable
{

	private static final long serialVersionUID = 763466429028153734L;
	private CustomTile tile;
	
	public WebWalkToTileAction(CustomTile tile)
	{
		this.tile = tile;
	}

	@Override
	public boolean run()
	{
		return WebWalking.walkTo(tile.toTileWrapper());
	}
	
	@Override
	public String toString()
	{
		return "attempt to WebWalk to "+tile.toString();
	}

}
