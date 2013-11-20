package scripts.ScriptMaker.api.types.intent.general;

import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.main.vars;

public class EndScriptAction extends Action
{

	private static final long serialVersionUID = 5232787455566284246L;

	@Override
	public boolean run()
	{
		vars.thread.interrupt();
		vars.gui.removeAll();
		vars.gui.setVisible(false);
		vars.gui.dispose();
		throw new RuntimeException(
				"End script action called");
	}

}
