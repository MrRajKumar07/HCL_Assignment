package com.example.atm;

public class UserAccount {
    private final String pin = "1234";
    private final int MaxAttempts = 3;
    private int attempts = 0;
    private boolean accessGranted = false;
    
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public boolean isAccessGranted() {
		return accessGranted;
	}
	public void setAccessGranted(boolean accessGranted) {
		this.accessGranted = accessGranted;
	}
	public String getPin() {
		return pin;
	}
	public int getMaxAttempts() {
		return MaxAttempts;
	}
    

}