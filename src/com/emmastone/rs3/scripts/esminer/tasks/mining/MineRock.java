package com.emmastone.rs3.scripts.esminer.tasks.mining;
import java.util.concurrent.Callable;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.GameObject;

import com.emmastone.rs3.scripts.esminer.data.Rock;
import com.emmastone.rs3.scripts.framework.Task;

public class MineRock extends Task {

	private Rock rockToMine;

	public MineRock(MethodContext ctx, Rock rockToMine) {
		super(ctx);
		this.rockToMine = rockToMine;
	}

	@Override
	public boolean activate() {
		return ctx.players.local().isIdle()
				&& ctx.backpack.select().count() != 28;
	}

	@Override
	public void execute() {
		GameObject rock = ctx.objects.select().id(rockToMine.getRockIds())
				.nearest().poll();
		
		if (rock.isInViewport()) {
			rock.interact("Mine");

		 } else {
             ctx.camera.turnTo(rock);
		}

		Condition.wait(new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				return ctx.players.local().getAnimation() != -1;
			}
		});
	}
}
