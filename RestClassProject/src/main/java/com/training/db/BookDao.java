package com.training.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public int addBook(Book book)
	{
		PreparedStatement pstmt=null;
		String template="insert into book values(?,?,?,?)";
		try {
			pstmt= connection.prepareStatement(template);
			pstmt.setLong(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setDouble(3, book.getPrice());
			pstmt.setLong(4, book.getStock());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	//delete a book
	public int deleteBook(Long isbn)
	{
		PreparedStatement pstmt=null;
		String template="delete from book where isbn=?";
		try {
			pstmt= connection.prepareStatement(template);
			
			pstmt.setLong(1, isbn);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	//update stock
	public int updateBook(Long isbn,Long newStock)
	{
		PreparedStatement pstmt=null;
		String template="update book set stock=stock+? where isbn=?";
		try {
			pstmt= connection.prepareStatement(template);
			pstmt.setLong(1, newStock);
			pstmt.setLong(2, isbn);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	

}
