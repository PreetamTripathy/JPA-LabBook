package com.cg.iter.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.iter.entity.Author;
import com.cg.iter.service.AuthorService;
import com.cg.iter.service.AuthorServiceImpl;

public class Application {

	public static void main(String[] args) {
		AuthorService service = new AuthorServiceImpl();
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Create Author");
				System.out.println("Enter <AuthorId> <FirstName> <MiddleName> <LastName> <PhoneNo>");
				Author auth = new Author(scan.nextInt(),scan.next(), scan.next(),scan.next(),scan.nextLong());
				boolean success = service.create(auth);
				if(success) {
					System.out.println("Author saved");
				}
				else {
					System.out.println("Could not save Author");
				}
				break;
			case 2:
				System.out.println("Update Author");
			    System.out.println("enter author ID: ");
			    auth=service.getAuth(scan.nextInt());
			    if(auth != null) {
			    	System.out.println("Enter new <FirstName> <MiddleName> <LastName> <PhoneNo>");
					auth.setFirstName(scan.next());
					auth.setMiddleName(scan.next());
					auth.setLastName(scan.next());
					auth.setPhoneNo(scan.nextLong());
					boolean success1 = service.update(auth);
					if (success1)
						System.out.println("Author updated");
					else
						System.out.println("Author could not be updated");
				}
			    
				break;
			case 3:
				System.out.println("Find Author");
				 System.out.println("enter author ID: ");
				    auth=service.getAuth(scan.nextInt());
				    System.out.println("Author found: " + auth);
				    if(auth != null) {
				    	System.out.println("Author found");
				    }
				    else {
							System.out.println("Author not found");
					}
				    
				break;
			case 4:
				System.out.println("Delete Author");
				System.out.println("enter the id you want to delete");
				auth=service.getAuth(scan.nextInt());
				System.out.println("Author found : " + auth);
				boolean success2 = service.delete(auth);
				if (success2)
					System.out.println("Author deleted");
				else
					System.out.println("Author not deleted");
				break;
			case 5:
				System.out.println("Exiting Program");
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 to 4 only");
				break;
			}
		}

	}

	private static int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("AUTHOR MANAGEMENT");
		System.out.println("1. Create Author");
		System.out.println("2. Update Author");
		System.out.println("3. Find Author");
		System.out.println("4. Delete Author");
		System.out.println("5. Exit Program");
		System.out.println("Choose the option from above");
		try {
		choice = scan.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Please choose a number");
			scan.nextLine();
		}
		return choice;
	}

}
