package com.emmastone.rs3.scripts.esminer.tasks.dropping;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

import com.emmastone.rs3.scripts.esminer.data.Rock;
import com.emmastone.rs3.scripts.framework.Task;

public class DropOres extends Task {

	private int[] oreIds = { Rock.COPPER.getOreId(), Rock.TIN.getOreId(),
			Rock.IRON.getOreId() };

	public DropOres(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;

	}

	@Override
	public void execute() {
		for (Item i : ctx.backpack.id(oreIds)) {
			i.interact("Drop");
		}

	}

}
