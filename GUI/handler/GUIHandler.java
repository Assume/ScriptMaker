package scripts.ScriptMaker.GUI.handler;

import java.util.ArrayList;
import java.util.List;

import scripts.ScriptMaker.GUI.BlockBuilderGUI;
import scripts.ScriptMaker.api.types.intent.gotos.Label;
import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.main.Conditional;
import scripts.ScriptMaker.api.types.main.ConditionalIntent;
import scripts.ScriptMaker.api.types.main.Intent;
import scripts.ScriptMaker.api.types.main.NilAction;
import scripts.ScriptMaker.main.vars;

public class GUIHandler
{

    private static List<Conditional> con = new ArrayList<Conditional>();
    private static Action action;
    private static Intent lastIntent;
    public static boolean isCreating = false;
    private static int indexTemp = BlockBuilderGUI.listModel.size();

    public static void addCondition(Conditional t)
    {
	isCreating = true;
	con.add(t);
	handleJListConditional();
    }

    public static void addLabel(String name)
    {
	if (con.size() != 0)
	{
	    BlockBuilderGUI.listModel
		    .remove(indexTemp);
	    con.clear();
	}
	setAction(new Label(name));
    }

    private static void handleJListConditional()
    {
	Conditional[] c = con.toArray(new Conditional[con.size()]);
	StringBuilder b = new StringBuilder();
	for (int i = 0; i < c.length; i++)
	{
	    if (i < c.length - 1)
		b.append(c[i] + " and ");
	    else
		b.append(c[i] + " ");
	}
	if (BlockBuilderGUI.listModel.size() > 0 && con.size() >= 2)
	    BlockBuilderGUI.listModel
		    .remove(indexTemp);
	BlockBuilderGUI.listModel.add(indexTemp, new ConditionalIntent(
		new NilAction(), con.toArray(new Conditional[con.size()])));
	BlockBuilderGUI.resetIndexes();
    }

    public static void fillJListWithIntents()
    {
	for (Intent t : Intent.getList())
	{
	    addItemToJList(t);
	}
	BlockBuilderGUI.resetIndexes();
    }

    private static void addItemToJList(Intent t)
    {
	BlockBuilderGUI.listModel.addElement(t);
    }

    private static void handleJListAction()
    {
	if (con.size() > 0)
	{

	    BlockBuilderGUI.listModel.remove(indexTemp);
	}
	BlockBuilderGUI.listModel.add(indexTemp, lastIntent);
	BlockBuilderGUI.resetIndexes();

    }

    public static void clearJList()
    {
	BlockBuilderGUI.listModel.clear();
    }

    public static void setAction(Action a)
    {
	action = a;
	handle();
	handleJListAction();
	resetAll();
    }

    public static void resetAll()
    {
	con.clear();
	action = null;
	lastIntent = null;
	isCreating = false;
	indexTemp = BlockBuilderGUI.listModel.size();
    }

    private static void handle()
    {
	if (con.size() == 0)
	{
	    Intent t = new Intent(action);
	    vars.currentIntentList.add(indexTemp, new Intent(action));
	    lastIntent = t;
	    return;
	} else
	{
	    ConditionalIntent t = new ConditionalIntent(action,
		    con.toArray(new Conditional[con.size()]));
	    vars.currentIntentList.add(indexTemp, t);
	    lastIntent = t;
	}
	BlockBuilderGUI.resetIndexes();
    }

    public static void setIndex(int indexTempp)
    {
	indexTemp = indexTempp;

    }

}
