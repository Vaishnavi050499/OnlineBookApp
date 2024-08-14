package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {
	List<Book> books = BookDetails.getBooks();

	@Override
	public List<Book> getAll() {
		return books;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> tempbookauthor = new ArrayList<>();
		for (Book book : books) {

			if (book.getAuthor().contains(author))
				tempbookauthor.add(book);
		}
		try {
			if (tempbookauthor.isEmpty()) {
				throw new BookNotFoundException(author+" "+"is not found..........");
			} else
				return tempbookauthor;

		} catch (BookNotFoundException e) {
			throw e;
		}
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> tempbookcategory = new ArrayList<>();
		for (Book book : books) {
			if (book.getCategory().equalsIgnoreCase(category))
				tempbookcategory.add(book);
		}
		try {
			if (tempbookcategory.isEmpty()) {
				throw new BookNotFoundException("Category is not found");
			} else
				return tempbookcategory;

		} catch (BookNotFoundException e) {
			throw e;
		}
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> tempbookprice = new ArrayList<>();
		for (Book book : books) {

			if (book.getPrice() < price)
				tempbookprice.add(book);
		}
		try {
			if (tempbookprice.isEmpty()) {
				throw new BookNotFoundException("Book less than this price is not available");
			} else
				return tempbookprice;

		} catch (BookNotFoundException e) {
			throw e;
		}
	}

	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
		List<Book> tempbookdate = new ArrayList<>();
		for (Book book : books) {

			if (book.getDatePublished().getYear() == year)
				tempbookdate.add(book);
		}
		try {
			if (tempbookdate.isEmpty()) {
				throw new BookNotFoundException("No book found for the given year");
			} else
				return tempbookdate;

		} catch (BookNotFoundException e) {
			throw e;
		}
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> tempauthandcateg = new ArrayList<>();
		for (Book book : books) {
			if ((book.getAuthor().contains(author)) && (book.getCategory().equalsIgnoreCase(category))) {
				tempauthandcateg.add(book);
			}
		}
		try {
			if (tempauthandcateg.isEmpty()) {
				throw new BookNotFoundException("No book found with same author and category");
			} else
				return tempauthandcateg;

		} catch (BookNotFoundException e) {
			throw e;
		}

	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		Boolean notfound = false;
		Book newbook = null;
		for (Book book : books) {
			if ((book.getBookId() == bookId)) {
				notfound = true;
				newbook = book;
			}
		}

		try {
			if (notfound == false) {
				throw new BookNotFoundException("BookId is not available");
			} else {
				return newbook;
			}

		} catch (BookNotFoundException e) {
			throw e;
		}

	}

}
