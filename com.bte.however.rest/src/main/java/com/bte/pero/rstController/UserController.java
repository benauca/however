package com.bte.pero.rstController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bte.however.dao.UserDao;
import com.bte.however.domain.UserDomain;
import com.bte.however.exception.UserNotFoundException;
import com.bte.hwvr.model.User;
import com.bte.pero.bean.Greeting;

@RestController
public class UserController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private Logger _logger = Logger.getLogger(UserController.class);

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		_logger.info("Esto es una prueba ");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	// @RequestMapping(value="/user", method=RequestMethod.POST )
	// public void saveUser(@RequestParam(value = "idUser", required = true)
	// long idUser) {
	// _logger.info("-----------------------------------------------------------------------------");
	// }

	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody final User user) {
		_logger.info("-------------------------------------------: " + user);
		UserDao aDao = new UserDao();
		UserDomain anUserDao = new UserDomain();
		anUserDao.setFullName(user.getFullName());
		anUserDao.setEmail(user.getEmail());
		anUserDao.setAuthType(user.getAuthType());
		anUserDao.setLogin(user.getLogin());
		aDao.persits(anUserDao);
		user.setId(anUserDao.getIdUser());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping("/user")
	public User getUser(@RequestParam(value = "idUser", required = true) int idUser) throws UserNotFoundException {
		UserDao anUsrDao = new UserDao();
		UserDomain aDomain = anUsrDao.findUserById(new Integer(idUser));
		User result = new User();
		result.setAuthType(aDomain.getAuthType());
		result.setEmail(aDomain.getEmail());
		result.setFullName(aDomain.getFullName());
		result.setLogin(aDomain.getLogin());
		result.setId(aDomain.getIdUser());
		return result;
	}

	@RequestMapping("/userByEmail")
	public User getUserByEmail(@RequestParam(value = "email", required = true) String email)
			throws UserNotFoundException {
		UserDao anUsrDao = new UserDao();
		UserDomain aDomain = anUsrDao.findUserByEmail(email);
		User result = new User();
		result.setAuthType(aDomain.getAuthType());
		result.setEmail(aDomain.getEmail());
		result.setFullName(aDomain.getFullName());
		result.setLogin(aDomain.getLogin());
		result.setId(aDomain.getIdUser());
		return result;
	}

	@RequestMapping("/users")
	public List<User> getUsers() {
		UserDao anUserDao = new UserDao();
		return null;// anUserDao.findAll();
	}

}
