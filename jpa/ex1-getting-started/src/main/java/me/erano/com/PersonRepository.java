package me.erano.com;

import java.util.Optional;

import org.springframework.data.repository.Repository;

interface PersonRepository extends Repository<Person, Long> {

	Person save(Person person);

	Optional<Person> findById(long id);
}
