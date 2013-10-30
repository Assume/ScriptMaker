package scripts.ScriptMaker.api.types.intent.mouse;

import java.io.Serializable;

import org.tribot.api.input.Mouse;

import scripts.ScriptMaker.api.types.main.Action;

public class LeftClickAction extends Action implements Serializable
{

	private static final long serialVersionUID = -5893094197649733698L;

	@Override
	public boolean run()
	{
		Mouse.click(1);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "left click";
	}
	
}
