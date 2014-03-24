package com.emmastone.rs3.scripts.esminer.tasks.banking;

import org.powerbot.script.methods.MethodContext;

import com.emmastone.rs3.scripts.esminer.data.Location;
import com.emmastone.rs3.scripts.framework.Task;

public class OpenBank extends Task {

	
	
	public OpenBank(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;

	}

	@Override
	public void execute() {
		if (ctx.bank.isInViewport()) {
			if (ctx.bank.open()) {
				ctx.bank.depositInventory();
				ctx.bank.close();
			}
		} else {
			Location.VARROCK_EAST_MINE.walkToBank(ctx);

		}
	}
}
