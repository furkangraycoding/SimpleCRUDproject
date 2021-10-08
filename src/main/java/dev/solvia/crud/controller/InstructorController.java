package dev.solvia.crud.controller;

import dev.solvia.crud.repository.InstructorRepository;
import dev.solvia.crud.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import dev.solvia.crud.exception.ResourceNotFoundException;
import dev.solvia.crud.model.Instructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class InstructorController {

	@Autowired
	InstructorService instructorService;
	
	// get all instructors
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors(){
		return instructorService.getAllInstructors();
	}		
	
	// create instructor rest api
	@PostMapping("/instructors")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		return instructorService.save(instructor);
	}
	
	// get instructor by id rest api
	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
		return instructorService.findById(id);
	}
	
	// update instructor rest api
	
	@PutMapping("/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorDetails){
		return instructorService.update(id, instructorDetails);
	}
	
	// delete instructor rest api
	@DeleteMapping("/instructors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInstructor(@PathVariable Long id){
		return instructorService.delete(id);
	}
	
	
}
