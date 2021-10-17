package com.ITrator.stm.request;

public class GlobalRequest 
{
	private Global global;
	
	public GlobalRequest(){
		
	}

	public Global getGlobal() {
		return global;
	}

	public void setGlobal(Global global) {
		this.global = global;
	}

	@Override
	public String toString() {
		return "GlobalRequest [global=" + global + "]";
	}
}
