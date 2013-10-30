package scripts.ScriptMaker.api.types.intent.mouse;

import java.io.Serializable;

import org.tribot.api.input.Mouse;

import scripts.ScriptMaker.api.types.main.Action;

public class RightClickAction extends Action implements Serializable
{

	private static final long serialVersionUID = -3022059491371683165L;

	@Override
	public boolean run()
	{
		Mouse.click(3);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "right click";
	}

}
