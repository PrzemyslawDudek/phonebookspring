package pl.dudekjunior.phonebook.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dudekjunior.phonebook.models.entities.PhoneBookEntity;

@Repository
public interface PhoneBookRepository extends CrudRepository<PhoneBookEntity, Integer> {
    boolean existsByNumber(int number);
}
