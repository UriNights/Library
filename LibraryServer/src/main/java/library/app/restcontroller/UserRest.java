package library.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.app.model.Lending;
import library.app.model.User;
import library.app.service.LendingService;
import library.app.service.UserService;

@RestController
@RequestMapping("/webapi")
public class UserRest {

	@Autowired
	UserService userService;
	@Autowired
	LendingService lendService;

	@GetMapping("/users")
	public Iterable<User> findAll() {
		return userService.findAll();
	}
	
	@PostMapping(path="/new_user", consumes="application/json")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PostMapping(path="/delete_user", consumes="application/json")
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}
	
	
	// Reservations from user. Active, past and new one
	@PostMapping(path="/user/active_lendings", consumes="application/json")
	public Iterable<Lending> activeLendings(@RequestBody User user) {
		return lendService.activeLendings(user);
	}
	
	@PostMapping(path="/user/past_lendings", consumes="application/json")
	public Iterable<Lending> pastLendings(@RequestBody User user) {
		return lendService.pastLendings(user);
	}
	
	@PostMapping(path="/user/new_lending", consumes="application/json")
	public void addlending(@RequestBody Lending lending) {
		lendService.addLending(lending);
	}
}