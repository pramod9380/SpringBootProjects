package com.example.exam.repository;

import com.example.exam.Model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Integer> {


}
