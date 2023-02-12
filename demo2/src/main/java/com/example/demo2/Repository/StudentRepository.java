package com.example.demo2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo2.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByAge(int i);

	List<Student> findByIdGreaterThan(int i);
	
	@Query("from Student where age=?1 order by name")
	List<Student> findByAgeSortedName(int i);

}
