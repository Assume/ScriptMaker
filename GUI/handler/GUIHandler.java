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
	private static int index;
	private static Intent lastIntent;

	public static void addCondition(Conditional t)
	{
		con.add(t);
		handleJListConditional();
	}
	
	public static void addLabel(String name)
	{
		if (con.size() != 0)
		{
			BlockBuilderGUI.listModel
							.remove(BlockBuilderGUI.listModel.size() - 1);
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
							.remove(BlockBuilderGUI.listModel.size() - 1);
		BlockBuilderGUI.listModel.addElement(new ConditionalIntent(
						new NilAction(), con
										.toArray(new Conditional[con.size()])));
	}

	public static void fillJListWithIntents()
	{
		for (Intent t : Intent.getList())
		{
			addItemToJList(t);
		}
	}

	private static void addItemToJList(Intent t)
	{
		BlockBuilderGUI.listModel.addElement(t);
	}

	private static void handleJListAction()
	{
		if (con.size() > 0)
		{
			BlockBuilderGUI.listModel
							.remove(BlockBuilderGUI.listModel.size() - 1);
		}
		if (index == -1)
		{
			index = BlockBuilderGUI.listModel.size() - 1;
		}
		BlockBuilderGUI.listModel.addElement(lastIntent);

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
		index = -1;
		action = null;
		lastIntent = null;
	}
	
	
	
	private static void handle()
	{
		if (con.size() == 0)
		{
			Intent t = new Intent(action);
			vars.currentIntentList.add(new Intent(action));
			lastIntent = t;
			return;
		}
		else
		{
			ConditionalIntent t = new ConditionalIntent(action, con
							.toArray(new Conditional[con.size()]));
			vars.currentIntentList.add(t);
			lastIntent = t;
		}
	}

}
