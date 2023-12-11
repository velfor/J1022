package by.itstep.h2db.repository;

import by.itstep.h2db.dto.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
