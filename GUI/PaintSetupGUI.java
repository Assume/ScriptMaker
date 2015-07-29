package scripts.ScriptMaker.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;

import scripts.ScriptMaker.api.methods.paint.ExperienceGainedPaintItem;
import scripts.ScriptMaker.api.methods.paint.GenericPaintItem;
import scripts.ScriptMaker.api.methods.paint.GenericPaintItemString;
import scripts.ScriptMaker.api.methods.paint.ItemCountPaintItem;
import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.methods.paint.generic.XPGainedGeneric;
import scripts.ScriptMaker.api.types.main.PaintItem;

public class PaintSetupGUI extends JFrame {

	private static final long serialVersionUID = 8624122728645045648L;

	private JPanel contentPane;
	private JTextField paintItemName;
	private JTextField textField_1;
	private Color inside;
	private Color border;
	private DefaultComboBoxModel<PaintItem> model = new DefaultComboBoxModel<PaintItem>();

	public PaintSetupGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblColorOne = new JLabel("Inside Color");
		lblColorOne.setBounds(10, 70, 75, 14);
		contentPane.add(lblColorOne);

		JLabel lblNewLabel = new JLabel("Border Color");
		lblNewLabel.setBounds(10, 103, 75, 15);
		contentPane.add(lblNewLabel);

		paintItemName = new JTextField();
		paintItemName.setBounds(126, 8, 185, 20);
		contentPane.add(paintItemName);
		paintItemName.setColumns(10);

		JLabel lblPaintItemName = new JLabel("Paint item name");
		lblPaintItemName.setBounds(10, 11, 106, 14);
		contentPane.add(lblPaintItemName);

		final JComboBox<PaintItem> paintTypeBox = new JComboBox<PaintItem>(
				model);
		paintTypeBox.setBounds(126, 131, 185, 20);
		contentPane.add(paintTypeBox);
		model.addElement(new ItemCountPaintItem(border, border, null, null, 0));
		model.addElement(new GenericPaintItem(border, border, null, null));
		model.addElement(new XPGainedGeneric(border, border, null, null));
		model.addElement(new GenericPaintItemString(border, border, null, null,
				null));

		JLabel lblPaintType = new JLabel("Paint type");
		lblPaintType.setBounds(10, 134, 65, 14);
		contentPane.add(lblPaintType);

		JLabel lblPaintText = new JLabel("Paint text");
		lblPaintText.setBounds(10, 45, 71, 14);
		contentPane.add(lblPaintText);

		textField_1 = new JTextField();
		textField_1.setBounds(126, 39, 185, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final PaintItem t;
				final PaintItem selected = (PaintItem) paintTypeBox
						.getSelectedItem();
				if (selected instanceof GenericPaintItem) {
					t = new GenericPaintItem(border, inside, paintItemName
							.getText(), textField_1.getText());
					PaintHandler.addItem(paintItemName.getText(), t);
					t.init();
				} else if (selected instanceof GenericPaintItemString) {
					String text = JOptionPane
							.showInputDialog("Enter the default text for this paint item");
					t = new GenericPaintItemString(border, inside,
							paintItemName.getText(), textField_1.getText(),
							text);
					PaintHandler.addItem(paintItemName.getText(), t);
					t.init();
				} else if (selected instanceof XPGainedGeneric) {
					JComboBox<SKILLS> b = new JComboBox<SKILLS>(Skills.SKILLS
							.values());
					JOptionPane.showMessageDialog(null, b, "Select a skill",
							JOptionPane.QUESTION_MESSAGE);
					Skills.SKILLS sk = (SKILLS) b.getSelectedItem();
					if (sk != null) {
						t = new ExperienceGainedPaintItem(border, inside,
								paintItemName.getText(), textField_1.getText(),
								sk);
						PaintHandler.addItem(paintItemName.getText(), t);
						t.init();
					}
				} else if (selected instanceof ItemCountPaintItem) {
					int itemId = Integer.parseInt(JOptionPane
							.showInputDialog("Enter the id of the item to track"));
					t = new ItemCountPaintItem(border, inside, paintItemName
							.getText(), textField_1.getText(), itemId);
					PaintHandler.addItem(paintItemName.getText(), t);
					t.init();
				}
			}
		});
		// hi
		btnAdd.setBounds(234, 162, 89, 23);
		contentPane.add(btnAdd);

		JButton btnSetInside = new JButton("Set");
		btnSetInside.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame t = new JFrame();
				t.setSize(455, 295);
				final JColorChooser c = new JColorChooser();
				t.getContentPane().add(c);
				c.getSelectionModel().addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent arg0) {
						inside = c.getColor();
						System.out.println(inside);
					}
				});
				t.setVisible(true);
			}
		});
		btnSetInside.setBounds(126, 66, 185, 23);
		contentPane.add(btnSetInside);

		JButton btnSetBorder = new JButton("Set");
		btnSetBorder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame t = new JFrame();
				t.setSize(455, 295);
				final JColorChooser c = new JColorChooser();
				t.getContentPane().add(c);
				c.getSelectionModel().addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent arg0) {
						border = c.getColor();
						System.out.println(border);
					}
				});
				t.setVisible(true);
			}
		});
		btnSetBorder.setBounds(126, 99, 185, 23);
		contentPane.add(btnSetBorder);

		JButton btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] p1 = PaintHandler.getAllExpItems();
					String[] p2 = PaintHandler.getAllOther();
					String[] f = new String[p1.length + p2.length];
					boolean d = false;
					for (int i = 0; i < p1.length + p2.length; i++) {
						if (i == p1.length)
							d = true;
						if (!d)
							f[i] = p1[i];
						else
							f[i] = p2[i];
					}
					JComboBox<String> box = new JComboBox<String>(f);
					JOptionPane.showMessageDialog(null, box,
							"Select a paint to remove",
							JOptionPane.QUESTION_MESSAGE);
					String remove = (String) box.getSelectedItem();
					PaintHandler.remove(remove);
				} catch (Exception d) {
					d.printStackTrace();
				}

			}
		});
		btnRemoveItem.setBounds(10, 165, 106, 23);
		contentPane.add(btnRemoveItem);
	}
}
