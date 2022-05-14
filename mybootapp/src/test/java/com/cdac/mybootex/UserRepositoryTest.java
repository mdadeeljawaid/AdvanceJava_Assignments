package com.cdac.mybootex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.cdac.mybootex.User;
import com.cdac.mybootex.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("adeel14@gmail.com");
		user.setFirstName("md adeel");
		user.setLastName("jawaid");
		user.setPassword("1234");
		//insert user
		User savedUser = urepo.save(user);
		// fetch user
		User existUser= entityManager.find(User.class, savedUser.getUserId());
		// email test
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());		
		
	}
	
	@Test
	public void testFindByEmail() {
		String emailString="adeel@gmail.com";
	   User user=urepo.findByEmail(emailString);
	   assertThat(user).isNotNull();
	}

}
