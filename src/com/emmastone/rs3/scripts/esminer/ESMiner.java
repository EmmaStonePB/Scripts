package com.emmastone.rs3.scripts.esminer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Skills;

import com.emmastone.rs3.scripts.esminer.data.Rock;
import com.emmastone.rs3.scripts.esminer.gui.Gui;
import com.emmastone.rs3.scripts.framework.Task;

@Manifest(description = "Super awesome basic mining script.", name = "ESMiner V1")
public class ESMiner extends PollingScript implements PaintListener {

	private List<Task> taskList = new ArrayList<Task>();
	long scriptRunTime = getTotalRuntime();

	private int startXp = 0;
	int xpGained = 0;
	long startTime;

	public String formatTime(final long time) {
		final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
		return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
				+ (s < 10 ? "0" + s : s);

	}

	public void start() {

		ctx.camera.setPitch(true);

		System.out.println(Rock.COPPER.getRockIds());
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Gui(ctx, taskList);
			}
		});
		startXp = ctx.skills.getExperience(Skills.MINING);

	}

	@Override
	public int poll() {
		for (Task task : taskList) {
			if (task.activate()) {
				task.execute();
			}
		}

		return 10;
	}

	@Override
	public void repaint(Graphics g) {

		xpGained = ctx.skills.getExperience(Skills.MINING) - startXp;

		long millis = System.currentTimeMillis() - startTime;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);

		g.setColor(Color.BLACK);
		g.drawRect(5, 5, 150, 81);
		g.setColor(Color.WHITE);
		g.fillRect(6, 6, 149, 80);
		g.setColor(Color.BLACK);
		g.setFont(new Font("PLAIN", 1, 12));
		g.drawString("ESMiner V1", 46, 23);
		g.setFont(new Font("PLAIN", 1, 9));
		g.drawString("XP Gained:", 15, 50);
		g.drawString(" " + xpGained, 100, 50);
		g.drawString("Timer:", 15, 70);
		g.drawString(" " + formatTime(getRuntime()), 100, 70);
		g.setFont(new Font("PLAIN", 3, 7));
		g.drawString("#EmmasCode", 100, 82);

	}

}
