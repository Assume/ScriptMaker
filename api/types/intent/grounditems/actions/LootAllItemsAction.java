package scripts.ScriptMaker.api.types.intent.grounditems.actions;

import java.awt.event.KeyEvent;

import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSGroundItem;
import org.tribot.api2007.types.RSTile;

import scripts.ScriptMaker.api.types.main.Action;

public class LootAllItemsAction extends Action
{

    private static final long serialVersionUID = -8400457127085801386L;

    private int[] id;

    public LootAllItemsAction(Integer[] integer)
    {
	this.id = convert(integer);
    }

    private int[] convert(Integer[] ids)
    {
	int[] temp = new int[ids.length];
	for (int i = 0; i < temp.length; i++)
	{
	    temp[i] = ids[i];
	}

	return temp;

    }

    @Override
    public boolean run()
    {
	loot(id);
	return true;
    }

    private void loot(int... id)
    {

	RSGroundItem[] itemsOnG = GroundItems.findNearest(id);
	if (itemsOnG.length == 0)
	{
	    return;
	}
	for (int a = 0; a < itemsOnG.length; a++)
	{

	    if (Inventory.isFull())
	    {
		return;
	    }
	    if (!Inventory.isFull())
	    {
		RSTile lootLoc = itemsOnG[a].getPosition();
		if (itemsOnG[a].isOnScreen() && itemsOnG[a] != null)
		{
		    Keyboard.pressKey((char) KeyEvent.VK_CONTROL);
		    itemsOnG[a].click("Take "
			    + itemsOnG[a].getDefinition().getName());
		    General.sleep(250, 350);
		    while (Player.isMoving())
			General.sleep(40);
		    Keyboard.releaseKey((char) KeyEvent.VK_CONTROL);
		} else if (!itemsOnG[a].isOnScreen() && itemsOnG[a] != null)
		{
		    Keyboard.pressKey((char) KeyEvent.VK_CONTROL);
		    Walking.walkPath((Positionable[]) Walking
			    .generateStraightPath((Positionable) lootLoc));
		    General.sleep(250, 350);
		    while (Player.isMoving())
			General.sleep(40);
		    itemsOnG[a].click("Take "
			    + itemsOnG[a].getDefinition().getName());
		    General.sleep(250, 350);
		    while (Player.isMoving())
			General.sleep(40);
		    Keyboard.releaseKey((char) KeyEvent.VK_CONTROL);
		}
	    }
	}
    }

}
