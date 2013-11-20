package scripts.ScriptMaker.api.types.main;

import java.io.Serializable;

public class ConditionalIntent extends Intent implements Serializable
{

	private static final long serialVersionUID = -8760950614272523193L;
	private Conditional[] c;

	public ConditionalIntent(final Action action, final Conditional... c)
	{
		super(action);
		this.c = c;
	}

	public ConditionalIntent()
	{

	}

	public Conditional[] getConditionals()
	{
		return c;
	}

	public boolean shouldExecute()
	{
		for (Conditional cs : c)
		{
			if (!cs.run())
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < c.length; i++)
		{
			if (i < c.length - 1)
				b.append(c[i] + " and ");
			else
				b.append(c[i] + " ");
		}
		if (!(super.getAction() instanceof NilAction))
		{
			b.append(" then: ");
			b.append(super.getAction());
		}
		return b.toString().trim();
	}

}
