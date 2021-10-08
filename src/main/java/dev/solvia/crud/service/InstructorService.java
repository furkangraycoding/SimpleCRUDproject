package dev.solvia.crud.service;


import dev.solvia.crud.exception.InstructorIsAlreadyExistException;
import dev.solvia.crud.exception.ResourceNotFoundException;
import dev.solvia.crud.model.Instructor;
import dev.solvia.crud.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;


    @Transactional(readOnly = true)
    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }


    @Transactional(readOnly = true)
    public ResponseEntity<Instructor> findById(long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not exist with id :" + id));
        return ResponseEntity.ok(instructor);
    }


    @Transactional
    public Instructor save(Instructor instructor) {
        boolean isExist= instructorRepository.selectExistInstructor(instructor.getEmail());
        if(isExist){
            throw new InstructorIsAlreadyExistException("Instructor Is Already Exist With Same Email!");}
        return instructorRepository.save(instructor);
    }


    @Transactional
    public ResponseEntity<Map<String, Boolean>> delete(Long id) {

        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not exist with id :" + id));

        instructorRepository.delete(instructor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<Instructor> update(Long id,Instructor instructorDetails) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not exist with id :" + id));

        boolean isExist= instructorRepository.selectExistInstructor(instructorDetails.getEmail());
        if(isExist){
            throw new InstructorIsAlreadyExistException("Instructor Is Already Exist With Same Email!");}

        instructor.setFirstName(instructorDetails.getFirstName());
        instructor.setLastName(instructorDetails.getLastName());
        instructor.setEmail(instructorDetails.getEmail());

        Instructor updatedInstructor = instructorRepository.save(instructor);
        return ResponseEntity.ok(updatedInstructor);
    }


}
