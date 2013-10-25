package scripts.ScriptMaker.api.types.intent.mouse;

import java.awt.Point;

import org.tribot.api.input.Mouse;

import scripts.ScriptMaker.api.types.main.Action;

public class MousePointAction extends Action
{

	private static final long serialVersionUID = -793750351962310375L;
	private Point p;
	
	public MousePointAction(Point p)
	{
		this.p = p;
	}

	@Override
	public boolean run()
	{
		Mouse.move(p);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "move mouse to "+"("+p.getX()+","+p.getY()+")";
	}

}
