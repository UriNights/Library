package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Lending;

public interface LendingRepository extends CrudRepository<Lending, Long> {
}
