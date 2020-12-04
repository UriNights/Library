package library.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Lending;
import library.app.model.User;
import library.app.repository.LendingRepository;
import library.app.repository.UserRepository;

@Service
public class LendingService {

	@Autowired
	LendingRepository repository;
	@Autowired
	UserRepository userRepository;

	public Iterable<Lending> findAll() {
		return repository.findAll();
	}

	public Iterable<Lending> pastLendings(User user) {
		return repository.findByUserAndActiveFalse(user);
	}

	public void addLending(Lending lending) {

		// Only can save after today
		if (lending.getLendingDate().isAfter(LocalDate.now())) {
			repository.save(lending);
		}
	}

	public void deleteLending(Lending lending) {

		// Only can delete if it's active and not in lending time
		if (lending.isActive() && lending.getLendingDate().isBefore(LocalDate.now())) {
			repository.delete(lending);
		}
	}

	public Iterable<Lending> activeLendings(Long _id) {

		return userRepository.findBy_id(_id).getLendings();
	}
}
