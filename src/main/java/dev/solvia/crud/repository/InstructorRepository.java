package dev.solvia.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dev.solvia.crud.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(i)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Instructor i " +
            "WHERE i.email = ?1")
    boolean selectExistInstructor(String email);

}
