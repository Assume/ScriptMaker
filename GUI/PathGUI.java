package scripts.ScriptMaker.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.ScriptMaker.GUI.handler.GUIHandler;
import scripts.ScriptMaker.api.types.intent.walking.actions.WalkPathAction;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class PathGUI extends JFrame
{


	private static final long serialVersionUID = 4654309625763629851L;

	private JPanel contentPane;

	private List<CustomTile> list;

	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JList<String> jlist = new JList<String>(model);
	private PathGUI th; 

	public PathGUI()
	{
		th = this;
		list = new ArrayList<CustomTile>();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddTile = new JButton("Add Tile");
		btnAddTile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				RSTile pos = Player.getPosition();
				CustomTile t = new CustomTile(pos.getX(), pos.getY());
				list.add(t);
				model.addElement(t.toString());
			}
		});
		btnAddTile.setBounds(10, 11, 89, 23);
		contentPane.add(btnAddTile);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 3, 309, 246);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(jlist);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GUIHandler.setAction(new WalkPathAction(list.toArray(new CustomTile[list.size()])));
				th.setVisible(false);
			}
		});
		btnDone.setBounds(10, 226, 89, 23);
		contentPane.add(btnDone);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int d = jlist.getSelectedIndex();
				if (d != -1)
				{
					model.remove(d);
					list.remove(d);
				}
			}
		});
		btnRemove.setBounds(10, 45, 89, 23);
		contentPane.add(btnRemove);
	}
}
