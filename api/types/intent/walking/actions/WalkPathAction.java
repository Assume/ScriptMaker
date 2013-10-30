package scripts.ScriptMaker.api.types.intent.walking.actions;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.tribot.api2007.Walking;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;
import scripts.ScriptMaker.api.types.wrappers.CustomTileUtil;

public class WalkPathAction extends Action implements Serializable
{

	private static final long serialVersionUID = -2399295088209857390L;
	private CustomTile[] tiles;
	private List<CustomTile> list;
	
	public WalkPathAction(CustomTile... tiles)
	{
		this.tiles = tiles;
		list = Arrays.asList(tiles);
	}

	@Override
	public boolean run()
	{
		return Walking.walkPath(CustomTileUtil.toRSTileArray(tiles));
	}
	
	@Override
	public String toString()
	{
		return "walking a path "+list;
	}

}
