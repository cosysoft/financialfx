package com.cosysoft.labs.financialfx.controller;

public class NullCommand implements Command {

	@Override
	public void execute() {

	}

	@Override
	public boolean cancellable() {
		return false;
	}

	@Override
	public void cancel() {

	}

}
