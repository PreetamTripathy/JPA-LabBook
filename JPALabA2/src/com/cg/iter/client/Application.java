package com.cg.iter.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.iter.entities.Author;
import com.cg.iter.entities.Book;
import com.cg.iter.service.AuthorBookServiceImpl;
import com.cg.iter.service.AuthorBookService;
import com.cg.iter.service.AuthorBookServiceImpl;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		AuthorBookService service = new AuthorBookServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
			choice = getChoice(sc);
			switch (choice) {
			
			case 1: List <Book> list=service.getAllBooks();
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
					  break;
			
			case 2: 
				try {
				System.out.println("Enter the author name");
					  String authorName=sc.next();
					  List<Book> bookByAuthor=service.getBooksByAuthor(authorName);
					  System.out.println("Book Details");
					  System.out.println(bookByAuthor);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
					  break;
			case 3: System.out.println("Enter the price range");
						double min= sc.nextDouble();
						double max= sc.nextDouble();
						List<Book> bookByPriceRange=service.getBooksByPriceRange(min, max);
						System.out.println("Book Details :");
						System.out.println(bookByPriceRange);
						break;
						
			case 4: 	System.out.println("Enter the book id");
						List<String> list1=service.getAuthorName(sc.nextInt());
						for (String s: list1)
							System.out.println("s");
						break;
						
			case 5:   System.exit(0);

			default:    System.out.println("Enter Valid Choice");
			}
		}
			
			private static int getChoice(Scanner scan) {
				int choice = 0;
				System.out.println("Enter your choice");
				System.out.println("1. Get all the books");
				System.out.println("2. Get books by author");
				System.out.println("3. Get book by price range");
				System.out.println("4. Get author name");
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