package scripts.ScriptMaker.api.types.intent.grounditems;

import java.io.Serializable;

import org.tribot.api2007.GroundItems;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ItemIsNotOnGroundConditional extends Conditional implements Serializable
{

    private static final long serialVersionUID = 8629517372690399330L;

    private int id;

    public ItemIsNotOnGroundConditional(int id)
    {
	this.id = id;
    }

    @Override
    public boolean run()
    {
	return GroundItems.find(id).length == 0;
    }

}
