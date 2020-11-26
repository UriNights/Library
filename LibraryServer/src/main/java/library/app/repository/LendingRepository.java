package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Lending;
import library.app.model.User;

public interface LendingRepository extends CrudRepository<Lending, Long> {

	Iterable<Lending> findByUserAndActiveTrue(User user);
	
	Iterable<Lending> findByUserAndActiveFalse(User user);
}