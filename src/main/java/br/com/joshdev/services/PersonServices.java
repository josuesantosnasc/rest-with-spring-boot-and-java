package br.com.joshdev.services;

import br.com.joshdev.exception.ResourceNotFoundException;
import br.com.joshdev.model.Person;
import br.com.joshdev.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository respository;

    public List<Person> findAll(){

        logger.info("Finding All People");

        return respository.findAll();

    }

    public Person findById(Long id){
        logger.info("Finding one Person");

        return respository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

    }

    public Person create(Person person){
        logger.info("Creating one Person ");

        return respository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one Person");

        Person entity=respository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return respository.save(person);
    }

    public void delete(Long id){
        logger.info("deleting one Person");

        Person entity=respository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        respository.delete(entity);

    }


}
