package dev.solvia.crud.controller;

import dev.solvia.crud.model.Instructor;
import dev.solvia.crud.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InstructorControllerTest {

    @Mock
    InstructorService mockInstructorService;

    @InjectMocks
    InstructorController instructorController;

    @Test
    void saveInstructor() {
        //given
        Instructor instructor = new Instructor();
        instructor.setEmail("furkangray@gmail.com");

        when(mockInstructorService.save(any())).thenReturn(instructor);
        System.out.println("1212" + instructor);


        // when
        Instructor dto = new Instructor();
        Instructor actual = this.instructorController.createInstructor(dto);


        System.out.println("1313" + dto);
        System.out.println("1313" + actual);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(instructor, actual),
                () -> assertEquals(instructor.getEmail(), actual.getEmail())
        );
} }