package scripts.ScriptMaker.api.types.intent.walking.actions;

import java.io.Serializable;

import org.tribot.api2007.Walking;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class WalkToTileAction extends Action implements Serializable
{

	private static final long serialVersionUID = -6664740302948699554L;
	private CustomTile tile;
	
	public WalkToTileAction(CustomTile tile)
	{
		this.tile = tile;
	}

	@Override
	public boolean run()
	{
		return Walking.blindWalkTo(tile.toTileWrapper());
	}
	
	@Override
	public String toString()
	{
		return "walk to "+tile.toString();
	}

}
