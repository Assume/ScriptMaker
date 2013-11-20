package scripts.ScriptMaker.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.main.Action;
import scripts.ScriptMaker.api.types.main.Conditional;
import scripts.ScriptMaker.api.types.main.ConditionalIntent;
import scripts.ScriptMaker.api.types.main.Intent;

public class IntentEditorGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DefaultListModel<Action> actionListModel;
	private DefaultListModel<Conditional> conditionListModel;

	private Block b;
	private Intent t;
	private boolean isConditional;

	private void fill()
	{
		actionListModel.clear();
		conditionListModel.clear();
		if (t instanceof ConditionalIntent)
		{
			for (Conditional x : ((ConditionalIntent) t).getConditionals())
				conditionListModel.addElement(x);
			actionListModel.addElement(t.getAction());
		}
		else
		{
			actionListModel.addElement(t.getAction());
		}
	}

	public IntentEditorGUI(Block b, Intent t)
	{
		this.b = b;
		this.t = t;
		this.isConditional = t instanceof ConditionalIntent;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 372, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 25, 318, 339);
		contentPane.add(scrollPane);

		conditionListModel = new DefaultListModel<Conditional>();
		JList<Conditional> conditionalList = new JList<Conditional>(
				conditionListModel);
		scrollPane.setViewportView(conditionalList);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 395, 318, 24);
		contentPane.add(scrollPane_1);
		actionListModel = new DefaultListModel<Action>();
		JList<Action> actionList = new JList<Action>(actionListModel);
		scrollPane_1.setViewportView(actionList);

		JButton doneBtn = new JButton("Done");
		doneBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});
		doneBtn.setBounds(250, 430, 89, 23);
		contentPane.add(doneBtn);
		this.fill();
	}

	public boolean isConditional()
	{
		return isConditional;
	}

	public void setConditional(boolean isConditional)
	{
		this.isConditional = isConditional;
	}

	public Block getB()
	{
		return b;
	}

	public void setB(Block b)
	{
		this.b = b;
	}
}
