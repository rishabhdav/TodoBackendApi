package com.ToDo.TODO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToDo.TODO.Entity.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task,String>{
    
}
