package com.emmastone.rs3.scripts.esminer.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

import com.emmastone.rs3.scripts.esminer.data.Rock;
import com.emmastone.rs3.scripts.esminer.tasks.banking.OpenBank;
import com.emmastone.rs3.scripts.esminer.tasks.banking.RockPath;
import com.emmastone.rs3.scripts.esminer.tasks.dropping.DropOres;
import com.emmastone.rs3.scripts.esminer.tasks.mining.MineRock;
import com.emmastone.rs3.scripts.framework.Task;

public class Gui extends MethodProvider {

	protected static final JComboBox Bank = null;
	protected static final JComboBox Drop = null;
	private JFrame frame = new JFrame();
	private List<Task> taskList;

	public Gui(MethodContext ctx, List<Task> taskList) {
		super(ctx);
		this.taskList = taskList;
		initialise();

	}

	private void initialise() {
		frame.getContentPane().setLayout(null);

		JLabel lblWouldYouLike = new JLabel("Would you like to bank or drop?");
		lblWouldYouLike.setBounds(87, 103, 205, 16);
		frame.getContentPane().add(lblWouldYouLike);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Bank",
				"Drop" }));
		comboBox_1.setBounds(141, 131, 98, 27);

		JLabel lblWhichTypeOf = new JLabel(
				"Which type of rock would you like to mine?");
		lblWhichTypeOf.setBounds(51, 18, 277, 16);
		frame.getContentPane().add(lblWhichTypeOf);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Copper",
				"Tin", "Iron" }));
		comboBox.setBounds(139, 50, 101, 27);
		frame.getContentPane().add(comboBox);

		JButton btnStart = new JButton("Start!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rockType = comboBox.getSelectedItem().toString();
				String actionType = comboBox_1.getSelectedItem().toString();

				if (actionType == "Bank") {
					taskList.add(new OpenBank(ctx));
					taskList.add(new RockPath(ctx));

				} else if (actionType == "Drop") {
					taskList.add(new DropOres(ctx));
				}

				if (rockType == "Copper") {
					taskList.add(new MineRock(ctx, Rock.COPPER));
				} else if (rockType == "Tin") {
					taskList.add(new MineRock(ctx, Rock.TIN));
				} else if (rockType == "Iron") {
					taskList.add(new MineRock(ctx, Rock.IRON));
				}

				frame.dispose();

			}
		});
		btnStart.setBounds(131, 179, 117, 29);
		frame.getContentPane().add(btnStart);
		frame.getContentPane().add(comboBox_1);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 380, 362);

	}
}
