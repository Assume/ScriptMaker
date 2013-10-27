package scripts.ScriptMaker.api.types.intent.grounditems.actions;

import org.tribot.api2007.GroundItems;
import org.tribot.api2007.types.RSGroundItem;

import scripts.ScriptMaker.api.types.main.Action;

public class ClickGroundItemAction extends Action
{

    private static final long serialVersionUID = -516844804153995986L;

    private int id;
    private String option;
    
    public ClickGroundItemAction(int id, String option)
    {
	this.id = id;
	this.option = option;
    }
    
    @Override
    public boolean run()
    {
	RSGroundItem[] items = GroundItems.find(id);
	if(items.length == 0)
	    return false;
	if (items[0].isOnScreen())
	    items[0].click(option);
	return false;
    }

    
    
}
