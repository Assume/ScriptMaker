package scripts.ScriptMaker.api.types.wrappers;

import java.io.Serializable;

public class CustomTile implements Serializable
{

    private static final long serialVersionUID = -6459860331915161454L;
    private int x;
    private int y;
    private int z;

    public CustomTile(int x, int y)
    {
	this(x, y, 0);
    }

    public CustomTile(int x, int y, int z)
    {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    public TileWrapper toTileWrapper()
    {
	return new TileWrapper(x, y);
    }

    @Override
    public String toString()
    {
	return "[" + x + "," + y + "," + z + "]";
    }
}
