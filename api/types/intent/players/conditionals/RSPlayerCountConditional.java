package scripts.ScriptMaker.api.types.intent.players.conditionals;

import org.tribot.api2007.Players;

import scripts.ScriptMaker.api.types.main.Conditional;

public class RSPlayerCountConditional extends Conditional
{

    private static final long serialVersionUID = -5262679873659133245L;

    private int count;

    public RSPlayerCountConditional(int count)
    {
	this.count = count;
    }

    @Override
    public boolean run()
    {
	return Players.getAll().length >= count;
    }

    
    @Override
    public String toString()
    {
	return "if at least "+count+" players are around"; 
    }
}
