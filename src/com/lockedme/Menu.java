package com.lockedme;

public class Menu {
	public static void welcomeScreen(String appName, String developerName) {
		String companyDetails = String.format("************************************************************\n"
				+ "\t\t  Welcome to %s.com \n" + "  This application was developed by %s\n"
				+ "************************************************************\n", appName, developerName);
		String appFunction = "This application enables you to:\n"
				+ "- Retrieve all file names in the \"main\" folder\n"
				+ "- Search, add, or delete files in \"main\" folder.\n";
		System.out.println(companyDetails);

		System.out.println(appFunction);
	}
	public static void optionsSelection() {
		System.out.println("\n-- Select any option number from below and press Enter --");
        String[] arr1 = {"1. Retrieve all files inside \"main\" folder in ascending order",
                "2. Business level operations",
                "3. Exit program",
        };
        for(int i=0; i<3;i++){
            System.out.println(arr1[i]);
            // display the all the Strings mentioned in the String array
        }
        
	}
	public static void displayFileMenuOptions() {
		System.out.println("\n-- Select any option number from below and press Enter --");
		String[] arr2 = {"1. Add a file to \"main\" folder",
                "2. Delete a file from \"main\" folder",
                "3. Search for a file from \"main\" folder",
                "4. Show Previous Menu",
                "5. Exit Application"
        };
        for(int i=0; i<5;i++){
            System.out.println(arr2[i]);
            // display the all the Strings mentioned in the String array
        }
	}
}