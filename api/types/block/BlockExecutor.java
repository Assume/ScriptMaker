package scripts.ScriptMaker.api.types.block;

import scripts.ScriptMaker.api.types.main.Intent;

public class BlockExecutor
{

	public static void execute(Block block)
	{
		Intent.executeAllIntents(block, 0);
	}

}
