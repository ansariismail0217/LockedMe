package com.lockedme;

public class Main {

	public static void main(String[] args) {
		
		FileOperations.createMainFolderIfNotPresent("main");
		Menu.welcomeScreen("LockedMe", "Abdullah Ismail Ansari");
		HandleOptions.handleWelcomeScreen();
	}

	
}