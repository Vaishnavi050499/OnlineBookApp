package com.bookapp.main;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import com.bookapp.util.BookDetails;

public class Client {

	public static void main(String[] args) {
		IBookService bookService = new BookServiceImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Please Select the option:");
			System.out.println("1.Get All the BookDetails:");
			System.out.println("2.Get the Books by Author:");
			System.out.println("3.Get the Books by Category:");
			System.out.println("4.Get the Books by Less Price:");
			System.out.println("5.Get the Books by Date:");
			System.out.println("6.Get the Books by Author and Category:");
			System.out.println("7.Get the Books by BookId:");
			System.out.println("8.Exit");

			int option = sc.nextInt();
			sc.nextLine();
			try {
				switch (option) {
				case 1:
					List<Book> bookprint = BookDetails.getBooks();
					for (Book book : bookprint) {
						System.out.println(book);
					}
					break;

				case 2:
					System.out.println("Please Enter the author name:");
					String author = sc.nextLine();
					List<Book> bookauthor = bookService.getByAuthorContains(author);
					for (Book book : bookauthor) {
						System.out.println(book);
					}
					break;

				case 3:
					System.out.println("Please Enter the category:");
					String category = sc.nextLine();
					List<Book> bookcateg = bookService.getByCategory(category);
					for (Book book : bookcateg) {
						System.out.println(book);
					}
					break;
				case 4:
					System.out.println("Please Enter the price:");
					double price = sc.nextDouble();
					List<Book> bookprice = bookService.getByPriceLessThan(price);
					for (Book book : bookprice) {
						System.out.println(book);
					}
					break;

				case 5:
					System.out.println("Please Enter the year:");
					int year = sc.nextInt();
					List<Book> bookdate = bookService.getByDatePublished(year);
					for (Book book : bookdate) {
						System.out.println(book);
					}
					break;

				case 6:
					System.out.println("Please Enter the author:");
					String author1 = sc.nextLine();
					System.out.println("Please Enter the category:");
					String categ = sc.nextLine();
					List<Book> bookauthcateg = bookService.getByAuthorContainsAndCategory(author1, categ);
					for (Book book : bookauthcateg) {
						System.out.println(book);
					}
					break;

				case 7:
					System.out.println("Please enter the bookId");
					int bookId = sc.nextInt();
					Book b1 = bookService.getById(bookId);
					System.out.println(b1);
					break;

				case 8:
					System.out.println("Thank you....");
					System.exit(0);
					break;

				default:
					System.exit(0);

				}
			} catch (BookNotFoundException e) {
				System.out.println(".........Exception............");
				System.err.println(e.getMessage());
			
				
			}
			
		}
	}
}
