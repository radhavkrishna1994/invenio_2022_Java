package com.training.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.classes.Book;
import com.training.db.DatabaseConnection;

public class BookDao {
	
	private Connection connection;
	
	public BookDao()
	{
		connection=DatabaseConnection.getConnection();
	}
	public List<Book> getBooks()
	{
		List<Book> bookList = new ArrayList<>();
		try {
		//Statement
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from book");
		while(rs.next())
		{
			Book book=new Book();
			book.setIsbn(rs.getLong(1));
			book.setTitle(rs.getString(2));
			book.setPrice(rs.getDouble(3));
			book.setStock(rs.getLong(4));
			bookList.add(book);
			
		}
		return bookList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
