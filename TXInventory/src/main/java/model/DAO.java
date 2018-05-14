package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	

	public void insert(String author, String title, String edition, String genre) throws Exception {
		Connection con = MySqlDbConnection.getDbConnection();
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, author);
		preparedStatement.setString(2, title);
		preparedStatement.setString(3, edition);
		preparedStatement.setString(4, genre);
		preparedStatement.executeUpdate();

	}

	public void update(String author, String title, String edition, String genre) throws Exception {
		Connection con = MySqlDbConnection.getDbConnection();
		PreparedStatement preparedStatement = con.prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, author);
		preparedStatement.setString(2, title);
		preparedStatement.setString(3, edition);
		preparedStatement.setString(4, genre);
		preparedStatement.executeUpdate();

	}

	public void delete(String author) throws Exception {
		Connection con = MySqlDbConnection.getDbConnection();
		PreparedStatement preparedStatement = con.prepareStatement(DELETE_QUERY);
		preparedStatement.setString(1, author);
		preparedStatement.executeUpdate();

	}

	public void getAllBooks() throws Exception {
		Connection con = MySqlDbConnection.getDbConnection();
		PreparedStatement preparedStatement = con.prepareStatement(RETRIEVE_QUERY);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("Author: " + resultSet.getString(1) + " " + "Title: " + resultSet.getString(2) + " "
					+ "Edition: " + resultSet.getString(3) + " " + "Genre: " + resultSet.getString(4));
		}
	}

	private static final String INSERT_QUERY = "insert into book(author,title,edition,genre) values(?,?,?,?)";
	private static final String UPDATE_QUERY = "update book set author=?, title=?,edition=?,genre=?";
	private static final String DELETE_QUERY = "delete from book where author=?";
	private static final String RETRIEVE_QUERY = "select author,title,edition,genre from book";

}
