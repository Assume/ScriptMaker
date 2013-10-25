package scripts.ScriptMaker.api.types.wrappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tribot.api2007.types.RSTile;

public class CustomTileUtil {

	public static TileWrapper[] toRSTileArray(CustomTile... t)
	{
		List<RSTile> list = new ArrayList<RSTile>();
		for(CustomTile x : t)
		{
			list.add(x.toTileWrapper());
		}
		return list.toArray(new TileWrapper[list.size()]);
	}

	public CustomTile[] toCustomTileArray(RSTile... t)
	{
		List<CustomTile> list = new ArrayList<CustomTile>();
		for(RSTile x : t)
		{
			list.add(new CustomTile(x.getX(), x.getY()));
		}
		return list.toArray(new CustomTile[list.size()]);
	}

	public static HashMap<String, TileWrapper[]> toMap(Map<String, CustomTile[]> t)
	{
		HashMap<String, TileWrapper[]> map = new HashMap<String, TileWrapper[]>();
		for(String d : t.keySet())
		{
			map.put(d, toRSTileArray(t.get(d)));
		}
		return map;	
	}
	
}
