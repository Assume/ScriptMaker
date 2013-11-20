package scripts.ScriptMaker.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import scripts.ScriptMaker.api.types.main.Intent;
import scripts.ScriptMaker.main.vars;

public class DebugGUI extends JFrame
{
	public static DefaultListModel<Intent> model = new DefaultListModel<Intent>();
	public static JList<Intent> list = new JList<Intent>(model);
	public static JLabel lblNewLabel = new JLabel("Current Block: ");
	private static final long serialVersionUID = 1L;

	private static JPanel contentPane;

	public static void redrawAll()
	{
		try
		{
			model.clear();
			if (vars.currentBlock == null)
				return;
			for (Intent t : vars.currentBlock.getIntets())
			{
				model.addElement(t);
			}
		}
		catch (Exception e)
		{

		}
	}

	public static void refresh()
	{
		try
		{
			list.repaint();
			}
		catch (Exception e)
		{

		}

	}

	public DebugGUI()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 12,
				SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);

		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 30,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 12,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 406,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 488,
				SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);

		list.setCellRenderer(new SelectedListCellRenderer());
		scrollPane.setViewportView(list);
	}

}

@SuppressWarnings("serial")
class SelectedListCellRenderer extends DefaultListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(
			@SuppressWarnings("rawtypes") JList list, Object value, int index,
			boolean isSelected, boolean cellHasFocus)
	{
		Component c = super.getListCellRendererComponent(list, value, index,
				isSelected, cellHasFocus);
		if (value.equals(vars.currentIntent))
		{
			c.setBackground(Color.GREEN);
		}
		return c;
	}
}
