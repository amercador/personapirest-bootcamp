package one.digitalinnovation.personapirest.service;

import one.digitalinnovation.personapirest.dto.request.PersonDTO;
import one.digitalinnovation.personapirest.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapirest.entity.Person;
import one.digitalinnovation.personapirest.mapper.PersonMapper;
import one.digitalinnovation.personapirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
