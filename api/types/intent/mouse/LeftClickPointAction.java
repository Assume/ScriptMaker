package scripts.ScriptMaker.api.types.intent.mouse;

import java.awt.Point;
import java.io.Serializable;

import org.tribot.api.input.Mouse;

import scripts.ScriptMaker.api.types.main.Action;

public class LeftClickPointAction extends Action implements Serializable
{

	private static final long serialVersionUID = 7318027270822035156L;
	private final Point p;

	public LeftClickPointAction(final Point p)
	{
		this.p = p;
	}

	@Override
	public boolean run()
	{
		Mouse.click(p, 1);
		return true;
	}

	@Override
	public String toString()
	{
		return "left click " + "(" + p.getX() + "," + p.getY() + ")";
	}

}
