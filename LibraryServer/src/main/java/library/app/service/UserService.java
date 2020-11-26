package library.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Person;
import library.app.model.User;
import library.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public Iterable<User> findAll() {
		return repository.findAll();
	}
	
	public Iterable<Person> findByName(String name) {
		return repository.findByName(name);
	}
	
	public void addUser(User user) {
		repository.save(user);
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}
}
