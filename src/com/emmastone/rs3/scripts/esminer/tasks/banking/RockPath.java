package com.emmastone.rs3.scripts.esminer.tasks.banking;
import org.powerbot.script.methods.MethodContext;

import com.emmastone.rs3.scripts.esminer.data.Location;
import com.emmastone.rs3.scripts.framework.Task;

public class RockPath extends Task {

	public RockPath(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		//May change this because people might have the pick in inv
		return ctx.backpack.select().count() == 0;
	}

	@Override
	public void execute() {

		Location.VARROCK_EAST_MINE.walkToMine(ctx);
	}

}
