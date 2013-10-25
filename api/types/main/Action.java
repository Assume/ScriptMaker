package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;

public abstract class Action implements Serializable
{

	private static final long serialVersionUID = -3123313290935024893L;

	public Action()
	{
		
	}
	
	public abstract boolean run();
	
}
