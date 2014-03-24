package com.emmastone.rs3.scripts.framework;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

public abstract class Task extends MethodProvider {

	public abstract boolean activate();

	public abstract void execute();

	public Task(MethodContext ctx) {
		super(ctx);
	}

}
