package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;
import java.util.Map;

import scripts.ScriptMaker.api.types.block.Block;

public class ScriptSaveFile implements Serializable
{

	private static final long serialVersionUID = 5345284954781313532L;

	private Map<String, Block> blocks;
	private Map<String, PaintItem> paint;
	private String name;
	
	public ScriptSaveFile(Map<String, Block> blocks, Map<String, PaintItem> paint, String name)
	{
		this.blocks = blocks;
		this.paint = paint;
		this.name = name;
	}

	public Map<String, Block> getBlocks()
	{
		return blocks;
	}

	public void setBlocks(Map<String, Block> blocks)
	{
		this.blocks = blocks;
	}

	public Map<String, PaintItem> getPaint()
	{
		return paint;
	}

	public void setPaint(Map<String, PaintItem> paint)
	{
		this.paint = paint;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
