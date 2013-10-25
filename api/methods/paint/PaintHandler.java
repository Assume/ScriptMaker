package scripts.ScriptMaker.api.methods.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.enums.SkillData;
import scripts.ScriptMaker.api.types.main.PaintItem;
import scripts.ScriptMaker.main.vars;


public class PaintHandler
{

	private static Map<String, PaintItem> map = new HashMap<String, PaintItem>();

	public static String[] getAllPaintItems()
	{
		return map.keySet().toArray(new String[map.size()]);
	}
	
	public static void initAll()
	{
	    for(PaintItem t : map.values())
	    {
		t.init();
	    }
	}
	
	public static Map<String, PaintItem> resetAllPaintItems(Map<String, PaintItem> map)
	{
	    PaintItem[] ts = map.values().toArray(new PaintItem[map.size()]);
	    String[] st = map.keySet().toArray(new String[map.size()]);
	    for(PaintItem t : ts)
	    {
		t.clearAll();
	    }
	    map.clear();
 	    for(int i = 0; i < ts.length; i++)
 	    {
 		for(String s : ts[i].values())
 		{
 		    System.out.println(s);
 		}
 		map.put(st[i], ts[i]);
 	    }
 	    return map;
	}
	
	public static void resetAllPaintItems()
	{
	    PaintItem[] ts = map.values().toArray(new PaintItem[map.size()]);
	    String[] st = map.keySet().toArray(new String[map.size()]);
	    for(PaintItem t : ts)
	    {
		t.clearAll();
	    }
	    map.clear();
 	    for(int i = 0; i < ts.length; i++)
 	    {
 		map.put(st[i], ts[i]);
 	    }
	}
	
	public static Map<String, PaintItem> getMap()
	{
		return map;
	}
	
	public static void setMap(Map<String, PaintItem> mapp)
	{
		map = mapp;
	}
	
	public static void paintAllItems(Graphics g)
	{
		if(map.size() == 0)
			return;
		
		int x = 10;
		int y = (map.size() * 10) + 100;
		String[] other = getAllOther();
		String[] exp = getAllExpItems();

		for (int i = 0; i < other.length; i++)
		{
			PaintItem t = map.get(other[i]);
			t.display(new Point(x, y + (i * 18)), g);
		}
		for (int b = 0; b < exp.length; b++)
		{
			PaintItem t = map.get(exp[b]);
			t.display(new Point(8, 348 + (b * 18)), g);
		}
	}

	public static void drawTimeRan(Graphics g, long runtime)
	{
		Graphics2D gd = (Graphics2D) g;
		final Color color2 = new Color(0, 0, 0);
		final BasicStroke stroke1 = new BasicStroke(1);
		String[] infoArray =
		{ "Runtime: " + SkillData.formatTime(vars.runtime)};

		int c = 0;
		for (String s : infoArray)
		{
			gd.setColor(new Color(255, 255, 255, 150));
			int length = DefaultMethods.stringLength(s, g);
			gd.fillRect(389, 440 + 17 * c, length + 16, 12);
			gd.setColor(color2);
			gd.setStroke(stroke1);
			gd.drawRect(389, 440 + 17 * c, length + 16, 12);
			gd.drawString(s, 399, 450 + 17 * c);
			c++;
		}
	}

	private static String[] getAllOther()
	{
		String[] items = map.keySet().toArray(new String[map.size()]);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < items.length; i++)
		{
			PaintItem t = map.get(items[i]);
			if (!(t instanceof ExperienceGainedPaintItem))
			{
				list.add(items[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	private static String[] getAllExpItems()
	{
		String[] items = map.keySet().toArray(new String[map.size()]);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < items.length; i++)
		{
			PaintItem t = map.get(items[i]);
			if (t instanceof ExperienceGainedPaintItem)
			{
				list.add(items[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	public static void addItem(String name, PaintItem t)
	{
		map.put(name, t);
	}

	public static void updateItem(String name)
	{
		if (map.containsKey(name))
		{
			PaintItem t = map.get(name);
			t.updateData();
			map.remove(name);
			map.put(name, t);
		}
	}

}
