package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.DAO;

@Controller
public class BooksCollection {
	DAO dao = new DAO();
	
	@GetMapping("/books")
	@ResponseBody
	public void getAvailableBooks() throws Exception {

		dao.getAllBooks();
	}

	public static void main(String[] args) throws Exception {
		BooksCollection booksCollection = new BooksCollection();
		booksCollection.getAvailableBooks();
	}
}
