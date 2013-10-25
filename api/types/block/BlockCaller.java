package scripts.ScriptMaker.api.types.block;

import scripts.ScriptMaker.api.types.block.handler.BlockHandler;
import scripts.ScriptMaker.api.types.main.Action;

public class BlockCaller extends Action
{

	private static final long serialVersionUID = -8376953461369866983L;

	private String name;
	
	public BlockCaller(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public boolean run()
	{
		BlockHandler.setCurrentName(name);
		BlockExecutor.execute(BlockHandler.getBlock(name));
		return true;
	}

	@Override
	public String toString()
	{
		return "executing block "+name;
	}
	
}
