package scripts.ScriptMaker.api.types.intent.bank;

import org.tribot.api2007.Banking;
import org.tribot.api2007.types.RSItem;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class WithdrawXOfYMultipleAction extends Action {

	private static final long serialVersionUID = -8032527776469979733L;

	private int[] ids;
	private int amount;

	public WithdrawXOfYMultipleAction(Integer[] ids, int amount) {
		this.ids = DefaultMethods.convertIntegerToInt(ids);
		this.amount = amount;
	}

	@Override
	public boolean run() {
		int tot = 0;
		for (int i = 0; i < ids.length && tot <= this.amount; i++) {
			RSItem[] item = Banking.find(ids[i]);
			if (item.length == 0)
				continue;
			Banking.withdraw(this.amount - tot, ids[i]);
			tot += item[0].getStack();
		}

		return true;
	}

}
