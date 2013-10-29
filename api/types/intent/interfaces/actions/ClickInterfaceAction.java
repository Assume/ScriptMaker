package scripts.ScriptMaker.api.types.intent.interfaces.actions;

import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterfaceChild;

import scripts.ScriptMaker.api.types.main.Action;

public class ClickInterfaceAction extends Action
{

    private static final long serialVersionUID = 3931302981547242631L;

    private int parent;
    private int child;
    private String action;

    public ClickInterfaceAction(int parent, int child, String action)
    {
	this.parent = parent;
	this.child = child;
	this.action = action;
    }

    @Override
    public boolean run()
    {
	RSInterfaceChild face = Interfaces.get(parent, child);
	if (face == null)
	    return false;
	return face.click(action);

    }
    
    @Override
    public String toString()
    {
	return "click "+ parent + ", " + child + " with the action"+action;
    }

}
