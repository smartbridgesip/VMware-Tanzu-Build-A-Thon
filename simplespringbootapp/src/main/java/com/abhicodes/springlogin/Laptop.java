package com.abhicodes.springlogin;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	private String model;
	private int ramSpace;
	private int hardDisk;
	public Laptop() {
		System.out.println("Laptop Object Created");
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRamSpace() {
		return ramSpace;
	}
	public void setRamSpace(int ramSpace) {
		this.ramSpace = ramSpace;
	}
	public int getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(int hardDisk) {
		this.hardDisk = hardDisk;
	}
	public void compile() {
		System.out.println("Code Executing...");
	}
}
