package scripts.ScriptMaker.api.types.block.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import scripts.ScriptMaker.GUI.BlockBuilderGUI;
import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.intent.gotos.Label;
import scripts.ScriptMaker.api.types.main.Intent;
import scripts.ScriptMaker.main.vars;

public class BlockHandler
{
	private static Map<String, Block> map = new HashMap<String, Block>();

	private static String currentBlockName;
	private static boolean isMain;
	private static String lastName;
	private static String currentName;

	public static String[] getAllBlockNames()
	{
		Set<String> d = map.keySet();
		return d.toArray(new String[d.size()]);
	}

	public static void setMap(Map<String, Block> mapp)
	{
		map = mapp;
	}

	public static Map<String, Block> getMap()
	{
		return map;
	}

	public static void setCurrentName(String cur)
	{
		currentName = cur;
	}

	public static String getCurrentName()
	{
		return currentName;
	}

	public static boolean isMainAdded()
	{
		return map.containsKey("main");
	}

	public static void setLastName(String name)
	{
		lastName = name;
	}

	public static String getLastName()
	{
		return lastName;
	}

	public static String[] getAllLabels()
	{
		List<String> list = new ArrayList<String>();

		for (Intent g : vars.currentIntentList
				.toArray(new Intent[vars.currentIntentList.size()]))
		{
			if (g.getAction() instanceof Label)
			{
				list.add(g.getAction().toString());
			}
		}
		return list.toArray(new String[list.size()]);
	}

	public static Block getMain()
	{
		return map.get("main");
	}

	public static int getLabelIndex(String name, String blockName)
	{
		Intent[] t = BlockHandler.getBlock(blockName).getIntets();
		for (int i = 0; i < t.length; i++)
		{
			if (t[i].getAction() instanceof Label)
			{
				if (t[i].getAction().toString().equals(name))
				{
					return i;
				}
			}
		}
		return -1;
	}

	public static void setMain(Block main)
	{
		if (map.containsKey("main"))
		{
			map.remove("main");
		}
		map.put("main", main);
	}

	public static void resetAll()
	{
		currentBlockName = null;
		isMain = false;
		BlockBuilderGUI.listModel.clear();
		vars.currentIntentList.clear();
	}

	public static Block[] getAllBlocks()
	{
		return map.values().toArray(new Block[map.size()]);
	}

	public static Block getBlock(String name)
	{
		return map.get(name);
	}

	public static void addBlock(String name, Block block)
	{
		if (map.containsKey(name))
		{
			map.remove(name);
		}
		map.put(name, block);

	}

	public static void setCurrentBlockName(String name)
	{
		currentBlockName = name;
	}

	public static String getCurrentBlockName()
	{
		return currentBlockName;
	}

	public static void setIsMain()
	{
		isMain = true;
	}

	public static boolean isMain()
	{
		return isMain;
	}
}
