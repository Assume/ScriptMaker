package scripts.ScriptMaker.api.types.intent.conditionals;

import java.io.Serializable;

import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Conditional;

public class AnimationIsConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = -426145591616468529L;

	private int animation;

	public AnimationIsConditional(int animation)
	{
		this.animation = animation;
	}

	@Override
	public boolean run()
	{
		return Player.getAnimation() == animation;
	}
	
	@Override
	public String toString()
	{
		return "if animation equals "+animation;
	}

}
