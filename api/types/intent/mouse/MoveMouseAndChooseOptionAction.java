package scripts.ScriptMaker.api.types.intent.mouse;

import java.awt.Point;
import java.io.Serializable;

import org.tribot.api.input.Mouse;
import org.tribot.api2007.ChooseOption;

import scripts.ScriptMaker.api.types.main.Action;

public class MoveMouseAndChooseOptionAction extends Action implements Serializable
{

	private static final long serialVersionUID = 3938600137853382051L;

	private final String option;
	private final Point p;

	public MoveMouseAndChooseOptionAction(final Point p, final String option)
	{
		this.p = p;
		this.option = option;
	}

	@Override
	public boolean run()
	{
		Mouse.move(p);
		Mouse.click(3);
		if (ChooseOption.isOpen())
		{
			ChooseOption.select(option);
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "move mouse to " + "(" + p.getX() + "," + p.getY() + ")"
				+ " and choose " + option;
	}

}
