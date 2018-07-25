package pl.dudekjunior.phonebook.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.phonebook.models.entities.PhoneBookEntity;
import pl.dudekjunior.phonebook.models.forms.PhoneBookForm;
import pl.dudekjunior.phonebook.models.repositories.PhoneBookRepository;

@Service
public class PhoneBookService {

    final PhoneBookRepository phoneBookRepository;

    @Autowired
    public PhoneBookService(PhoneBookRepository phoneBookRepository){
        this.phoneBookRepository = phoneBookRepository;
    }

    public boolean tryToAddNumber(PhoneBookForm phoneBookForm){
        if(phoneBookRepository.existsByNumber(phoneBookForm.getNumber())){
            return false;
        }

        PhoneBookEntity phoneBookEntity = createPhoneBookEntity(phoneBookForm);
        phoneBookRepository.save(phoneBookEntity);
        return true;
    }

    private PhoneBookEntity createPhoneBookEntity(PhoneBookForm phoneBookForm){
        PhoneBookEntity phoneBookEntity = new PhoneBookEntity();
        phoneBookEntity.setName(phoneBookForm.getName());
        phoneBookEntity.setSurname(phoneBookForm.getSurname());
        phoneBookEntity.setNumber(phoneBookForm.getNumber());
        return phoneBookEntity;
    }

}
