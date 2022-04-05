package com.lockedme;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.*;

public class HandleOptions {
	public static void handleWelcomeScreen() {
		boolean running = true;
		Scanner sc1 = new Scanner(System.in);
		do {
			try {
				Menu.optionsSelection();
				int inp = sc1.nextInt();
				switch (inp) {
				case 1: {
					FileOperations.displayAllFiles("main");
					break;
				}
				case 2: {
					handleBusinessLevelOp();
					break;
				}
				case 3: {
					System.out.println("Application closed successfully.");
					running = false;
					sc1.close();
					System.exit(0);
					break;
				}
				default:
					System.out.println("Invalid choice! Please select a valid option.");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getClass().getName());
			}
		}
		while(running);
	}
	
	public static void handleBusinessLevelOp() {
	//This method handles business level operations
		boolean running = true;
		Scanner sc2 = new Scanner(System.in);
		do {
			try {
				Menu.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotPresent("main");
				int inp = sc2.nextInt();
				
				switch (inp) {
				case 1: {
					// Adding a file
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String addFile = sc2.next();
					FileOperations.createFile(addFile);
					break;
				}
				case 2: {
					// Deleting a file
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc2.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					
					if(filesToDelete.isEmpty())
						break;
					else {
						System.out.println(deletionPrompt);
						
						int idx = sc2.nextInt();
						
						if (idx != 0) {
							FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
						} 
						else {
							
							// If idx == 0, delete all files displayed for the name
							for (String path : filesToDelete) {
								FileOperations.deleteFileRecursively(path);
							}
						}
					}
					break;
				}
				case 3: {
					//Searching a file
					FileOperations.createMainFolderIfNotPresent("main");
					String path = "main";
			        System.out.println("Enter the file to be searched: " );
			        String name = sc2.next();
			        FileOperations.displayFileLocations(name, path);
			        break;
				}
				case 4: {
					//Go to previous menu
					return;
				}
				case 5: {
					// Exit
					System.out.println("Application closed successfully.");
					running = false;
					sc2.close();
					System.exit(0);
				}
				default:
					System.out.println("Please select a valid option from above.");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getClass().getName());
				handleBusinessLevelOp();
			}
		}
		while(running);
	}
}
