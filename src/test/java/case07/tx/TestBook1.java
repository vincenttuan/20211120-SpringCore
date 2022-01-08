package case07.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case07.tx.controller.BookController;

public class TestBook1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean("bookController", BookController.class);
		
		System.out.println(bookController);
		// case 1
		/*
		Integer wid = 1;
		Integer bid = 1;
		bookController.buyBook(wid, bid);
		*/
		
		// case 2
		/*
		Integer wid = 2;
		Integer bid = 1;
		bookController.buyBook(wid, bid);
		*/
		
		// case 2
		// BookServiceImpl.java buyOne() 加入 @Transactional(propagation = Propagation.REQUIRED)
		/*
		Integer wid = 2;
		Integer bid = 1;
		bookController.buyBook(wid, bid);
		*/
		
		Integer wid = 1;
		bookController.buyBooks(wid, 1, 2, 3);
		
	}
}
