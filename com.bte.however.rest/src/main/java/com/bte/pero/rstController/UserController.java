package com.bte.pero.rstController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.bte.however.exception.UserNotValidException;
import com.bte.hwvr.model.User;
import com.bte.pero.bean.Greeting;

@RestController
public class UserController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private Logger _logger = LogManager.getLogger(UserController.class);

	@RequestMapping(value = "/however/user/new", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody final User user) {
		_logger.info("-------------------------------------------: " + user);
		UserDao aDao = new UserDao();
		UserDomain anUserDom = new UserDomain();
		anUserDom.setFullName(user.getFullName());
		anUserDom.setEmail(user.getEmail());
		anUserDom.setAuthType(user.getAuthType());
		anUserDom.setLogin(user.getLogin());
		anUserDom.setPassword(user.getPassword());
		anUserDom.setAdmin(user.isAdmin());
		aDao.persits(anUserDom);
		user.setId(anUserDom.getIdUser());
		_logger.debug(user.toString());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value="/however/user/get", method=RequestMethod.POST)
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

	@RequestMapping(value="/however/user/validateUser", method=RequestMethod.POST)
	public User getUserByEmail(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password)
			throws UserNotFoundException, UserNotValidException {
		UserDao anUsrDao = new UserDao();
		UserDomain aDomain = anUsrDao.findUserByEmail(email);

		if (!aDomain.getPassword().equals(password)) {
			_logger.error("Usuario no válido. Revise la contraseña introducida por el usuario.");
			throw new UserNotValidException("Usuario no válido. Revise la contraseña introducida por el usuario.");
		}
		User result = new User();
		result.setAuthType(aDomain.getAuthType());
		result.setEmail(aDomain.getEmail());
		result.setFullName(aDomain.getFullName());
		result.setLogin(aDomain.getLogin());
		result.setId(aDomain.getIdUser());
		return result;
	}

	@RequestMapping(value="/however/user/list", method=RequestMethod.POST)
	public List<User> getUsers() {
		UserDao anUserDao = new UserDao();
		anUserDao.findAll();
		return null;
	}

}
