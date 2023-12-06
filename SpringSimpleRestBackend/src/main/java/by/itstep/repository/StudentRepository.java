package by.itstep.repository;

import by.itstep.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
