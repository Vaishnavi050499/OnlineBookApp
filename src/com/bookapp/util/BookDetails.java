package com.bookapp.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.bookapp.model.Book;

public class BookDetails {
public static List<Book> getBooks(){
	List<Book> books = Arrays.asList(new Book("The Silent Patient", 101, 19.99, "Alex Michaelides", "Thriller", LocalDate.of(2019, 2, 5)),
			new Book("Educated", 102, 14.95, "Alex Westover", "Memoir", LocalDate.of(2018, 2, 20)),
			new Book("Becoming", 103, 24.99, "Michelle Obama", "Biography", LocalDate.of(2018, 11, 13)),
			new Book("Where the Crawdads Sing", 104, 15.99, "Delia Owens", "Fiction", LocalDate.of(2018, 8, 14)),
			new Book("Sapiens: A Brief History of Humankind", 105, 22.50, "Yuval Noah Harari", "Fiction", LocalDate.of(2014, 9, 4)),
			new Book("Atomic Habits", 106, 16.00, "James Clear", "Self-help", LocalDate.of(2018, 10, 16))
);
	return books;
}
}
