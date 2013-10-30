package scripts.ScriptMaker.api.types.intent.grounditems;

import java.io.Serializable;

import org.tribot.api2007.GroundItems;
import org.tribot.api2007.types.RSGroundItem;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ItemIsNotOnScreenConditional extends Conditional implements Serializable
{

    private static final long serialVersionUID = -4771314324271731019L;

    private int id;
    
    public ItemIsNotOnScreenConditional(int id)
    {
	this.id = id;
    }
    
    @Override
    public boolean run()
    {
	RSGroundItem[] items = GroundItems.find(id);
	if (items.length == 0)
	    return false;
	if (items[0].isOnScreen())
	    return true;
	return false;
    }

}
