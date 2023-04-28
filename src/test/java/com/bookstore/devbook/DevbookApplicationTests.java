package com.bookstore.devbook;

import com.bookstore.devbook.controller.BookController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevbookApplicationTests {

	@Autowired
	private BookController controller;
	@Test
	void contextLoads() {
		Assertions.assertTrue(controller != null);
	}

}
