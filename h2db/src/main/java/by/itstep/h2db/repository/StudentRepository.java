package by.itstep.h2db.repository;

import by.itstep.h2db.dto.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    /*
    @Modifying
    @Query("UPDATE Student s SET s.avg_mark = :student.avg_mark WHERE s.id = :id ")
    void setAvg(@Param("id") Integer id, @Param("student") Student student);
    */
}
