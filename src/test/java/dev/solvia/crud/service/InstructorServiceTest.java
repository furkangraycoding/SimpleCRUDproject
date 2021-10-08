package dev.solvia.crud.service;

import dev.solvia.crud.controller.InstructorController;
import dev.solvia.crud.exception.InstructorIsAlreadyExistException;
import dev.solvia.crud.model.Instructor;
import dev.solvia.crud.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {

    @Mock
    InstructorRepository mockInstructorRepository;

    @InjectMocks
    InstructorService instructorService;


    @Test
    void getAllInstructors() {
        // given
        Mockito.when(mockInstructorRepository.findAll()).thenReturn(Collections.singletonList(
                new Instructor("Koray", "gray","k@g.com")
        ));

        // when
        List<Instructor> expected = instructorService.getAllInstructors();

        // then
        assertEquals(expected.get(0).getEmail(),"k@g.com");
    }

    }
