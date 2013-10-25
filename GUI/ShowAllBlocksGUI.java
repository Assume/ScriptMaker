package scripts.ScriptMaker.GUI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.block.handler.BlockHandler;

public class ShowAllBlocksGUI extends JFrame
{
	private static final long serialVersionUID = 7410422542230076601L;

	private JPanel contentPane;

	private  DefaultListModel<String> model = new DefaultListModel<String>();

	public ShowAllBlocksGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 415, 628);
		contentPane.add(scrollPane);

		JList<String> list = new JList<String>(model);
		scrollPane.setViewportView(list);
		model.clear();
		this.fillList();
	}

	private void fillList()
	{
		if (BlockHandler.isMainAdded())
		{
			for (String s : BlockHandler.getMain().toFormattedString())
			{
				model.addElement(s);
			}
			model.addElement("");
		}
		for (Block b : BlockHandler.getAllBlocks())
		{
			if(!b.getName().equals("main"))
			{
				for (String s : b.toFormattedString())
				{
					model.addElement(s);
				}
				model.addElement("");
			}
		}
	}
}
