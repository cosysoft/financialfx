package com.cosysoft.labs.financialfx.controller;

public interface Command {

	void execute();
	
	boolean cancellable();
	
	void cancel();
}
