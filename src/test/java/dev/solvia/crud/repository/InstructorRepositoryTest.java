package dev.solvia.crud.repository;

import dev.solvia.crud.model.Instructor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "jdbc:mysql://localhost:3306/ooptest?characterEncoding=UTF8"
})
class InstructorRepositoryTest {

    @Autowired
    InstructorRepository instructorRepository;

    @Test
    public void should_find_no_instructor_if_repository_is_empty() {
        Iterable<Instructor> tutorials = instructorRepository.findAll();

        assertTrue(((List<Instructor>) tutorials).isEmpty());
    }

    @AfterEach
    public void tearDown(){
        instructorRepository.deleteAll();
    }

    @Test
    void shouldCheckWhenInstructorEmailIsExists() {
        // given
        Instructor instructor = new Instructor("Koray","gray", "k@g.com");
        instructorRepository.save(instructor);

        // when
        boolean expected = instructorRepository.selectExistInstructor(instructor.getEmail());

        // then
        assertTrue(expected);
    }

    @Test
    void shouldCheckWhenInstructorEmailIsNotExists() {
        // given
        Instructor instructor = new Instructor("Koray","gray", "k@g.com");

        // when
        boolean expected = instructorRepository.selectExistInstructor(instructor.getEmail());

        // then
        assertFalse(expected);
    }

}