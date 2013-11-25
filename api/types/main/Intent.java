package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import scripts.ScriptMaker.GUI.DebugGUI;
import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.block.handler.BlockHandler;
import scripts.ScriptMaker.api.types.intent.gotos.GOTOAction;
import scripts.ScriptMaker.api.types.intent.gotos.Label;
import scripts.ScriptMaker.main.vars;

public class Intent implements Serializable
{

	private static final long serialVersionUID = 3828909368490305034L;

	private static List<Intent> INTENTS = new ArrayList<Intent>();

	private Action action;

	public Intent(Action action)
	{
		this.action = action;
	}

	public Intent()
	{

	}

	public boolean execute()
	{
		return action.run();
	}

	public static List<Intent> getList()
	{
		return INTENTS;
	}

	public static void setList(List<Intent> l)
	{
		INTENTS = l;
	}

	public static String[] getAllLabels()
	{
		List<String> list = new ArrayList<String>();

		for (Intent t : INTENTS.toArray(new Intent[INTENTS.size()]))
		{
			if (t.getAction() instanceof Label)
			{
				list.add(t.getAction().toString());
			}
		}
		return list.toArray(new String[list.size()]);
	}

	public static void remove(int index)
	{
		INTENTS.remove(index);
	}

	public static void executeAllIntents(Block b, int dt)
	{
		vars.currentBlock = b;
		DebugGUI.lblNewLabel.setText("Current Block: "+b.getName());
		DebugGUI.redrawAll();
		Intent[] intents = b.getIntets();
		for (int i = dt; i < intents.length; i++)
		{
			if(vars.isHopping)
			{
				i--;
				continue;
			}
			if(vars.pause)
			{
				i--;
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				continue;	
			}
			vars.currentIntent = intents[i];
			DebugGUI.refresh();
			if (b.getName().equals("main"))
				vars.lastIndex = i;
			if (vars.fullStop)
			{
				break;
			}
			if (intents[i] instanceof ConditionalIntent)
			{
				if (((ConditionalIntent) intents[i]).shouldExecute())
				{
					if (intents[i].getAction() instanceof GOTOAction)
					{
						int index = BlockHandler.getLabelIndex(
								((GOTOAction) intents[i].getAction())
										.getLabel(), b.toString());
						if (index != -1)
						{
							i = index;
							continue;
						}
					}
					vars.status = intents[i].getAction().toString();
					intents[i].execute();
				}
			}
			else
			{
				if (intents[i].getAction() instanceof GOTOAction)
				{
					int index = BlockHandler.getLabelIndex(
							((GOTOAction) intents[i].getAction()).getLabel(),
							b.toString());
					if (index != -1)
					{
						i = index;
						continue;
					}
				}
				vars.status = intents[i].getAction().toString();
				intents[i].execute();
			}
		}
		BlockHandler.setCurrentName(BlockHandler.getLastName());
	}

	public static Intent getIntent(int index)
	{
		return INTENTS.get(index);
	}

	public static Intent getLatestIntent()
	{
		return INTENTS.get(INTENTS.size() - 1);
	}

	public static void addIntent(Intent t)
	{
		INTENTS.add(t);
	}

	public static void removeIntent(Intent t)
	{
		INTENTS.remove(t);
	}

	public Action getAction()
	{
		return action;
	}

	public void setAction(Action action)
	{
		this.action = action;
	}

	@Override
	public String toString()
	{
		return action.toString().trim();
	}

}
