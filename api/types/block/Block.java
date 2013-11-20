package scripts.ScriptMaker.api.types.block;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import scripts.ScriptMaker.api.types.main.Intent;

public class Block implements Serializable
{

	private static final long serialVersionUID = 2136902093009595932L;

	private Intent[] intets;
	private String name;

	public Block(Intent[] intents, String name)
	{
		this.intets = intents;
		this.name = name;
	}

	public Intent[] getIntets()
	{
		return intets;
	}

	public void replaceIntent(Intent orig, Intent ne)
	{
		for(int i = 0; i < intets.length; i++)
		{
			if(intets[i].equals(orig))
			{
				intets[i] = ne;
				break;
			}
		}
	}

	public void setIntets(Intent[] intets)
	{
		this.intets = intets;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] toFormattedString()
	{
		List<String> list = new ArrayList<String>();
		list.add("Start Block " + name);
		for (Intent s : this.intets)
		{
			list.add(s.toString());
		}
		list.add("End Block " + name);
		list.add(" ");
		return list.toArray(new String[list.size()]);
	}

	@Override
	public String toString()
	{
		return name;
	}

}
