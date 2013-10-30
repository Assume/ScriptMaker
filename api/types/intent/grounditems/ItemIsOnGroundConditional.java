package scripts.ScriptMaker.api.types.intent.grounditems;

import java.io.Serializable;

import org.tribot.api2007.GroundItems;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ItemIsOnGroundConditional extends Conditional implements Serializable
{

    private static final long serialVersionUID = 395890540770264405L;

    private int[] id;

    public ItemIsOnGroundConditional(int... id)
    {
	this.id = id;
    }

    @Override
    public boolean run()
    {
	return GroundItems.find(id).length > 0;
    }

    public int[] getId()
    {
	return id;
    }

    public void setId(int[] id)
    {
	this.id = id;
    }

}
