package br.com.joshdev.repository;

import br.com.joshdev.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
