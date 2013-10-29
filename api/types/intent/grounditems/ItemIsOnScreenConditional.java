package scripts.ScriptMaker.api.types.intent.grounditems;

import org.tribot.api2007.GroundItems;
import org.tribot.api2007.types.RSGroundItem;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ItemIsOnScreenConditional extends Conditional
{

    private static final long serialVersionUID = -5572369739889050996L;

    private int id;

    public ItemIsOnScreenConditional(int id)
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