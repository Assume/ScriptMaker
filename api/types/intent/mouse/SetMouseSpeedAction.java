package scripts.ScriptMaker.api.types.intent.mouse;

import org.tribot.api.input.Mouse;

import scripts.ScriptMaker.api.types.main.Action;

public class SetMouseSpeedAction extends Action
{

	private static final long serialVersionUID = -2762219048521022853L;
	private int speed;
	
	public SetMouseSpeedAction(final int speed)
	{
		this.speed = speed;
	}

	@Override
	public boolean run()
	{
		Mouse.setSpeed(speed);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "set mouse to speed "+speed;
	}
	
}
