package scripts.ScriptMaker.api.types.intent.walking.actions;

import java.io.Serializable;

import org.tribot.api2007.util.PathNavigator;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class AStarWalkAction extends Action implements Serializable
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
    
    @Override
    public String toString()
    {
	return "A* walk to "+tile.toString();
    }

}
