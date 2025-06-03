package br.com.joshdev.services;

import br.com.joshdev.data.dto.v1.PersonDTO;
import br.com.joshdev.data.dto.v2.PersonDTOV2;
import br.com.joshdev.exception.ResourceNotFoundException;
import static br.com.joshdev.mapper.ObjectMapper.parseListObjects;
import static br.com.joshdev.mapper.ObjectMapper.parseObject;

import br.com.joshdev.mapper.custom.PersonMapper;
import br.com.joshdev.model.Person;
import br.com.joshdev.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository respository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll(){

        logger.info("Finding All People");

        return parseListObjects(respository.findAll(),PersonDTO.class);

    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person");
        var entity= respository.findById((id)).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        return parseObject(entity,PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person ");

        var entity=parseObject(person,Person.class);

        return parseObject(respository.save(entity),PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating one Person ");

        var entity=converter.convertDTOToEntity(person);

        return converter.convertEntityToDTO(respository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating one Person");

        Person entity=respository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(respository.save(entity),PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("deleting one Person");

        Person entity=respository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        respository.delete(entity);

    }


}
