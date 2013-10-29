package scripts.ScriptMaker.api.types.intent.walking.actions;

import org.tribot.api2007.util.PathNavigator;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class AStarWalkAction extends Action
{

    private static final long serialVersionUID = -36174339554504713L;

    private CustomTile tile;

    public AStarWalkAction(CustomTile tile)
    {
	this.tile = tile;
    }

    @Override
    public boolean run()
    {
	return new PathNavigator().traverse(tile.toTileWrapper());
    }

}
