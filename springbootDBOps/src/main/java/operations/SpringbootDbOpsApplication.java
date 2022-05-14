package operations;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cdac.dao.entity.Book;
import com.cdac.daooperation.BookRepository;

@SpringBootApplication
@EnableJpaRepositories("com.cdac.daooperation")
@EntityScan("com.cdac.dao.entity")
public class SpringbootDbOpsApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(SpringbootDbOpsApplication.class, args);
	BookRepository bookRepository = context.getBean(BookRepository.class);
	Book book = new Book();
	book.setBookName("let us c");
	book.setPublisher("xyz");
	Book b1 = bookRepository.save(book);
	System.out.println(b1);
	
	// update on basis of id 
		Optional<Book>  optional=  bookRepository.findById(2);
		Book b = optional.get();
		b.setBookName("hulk");
		bookRepository.save(b);
		System.out.println("book detail"+b);
	}

}
