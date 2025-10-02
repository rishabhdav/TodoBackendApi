package com.ToDo.TODO.Service;

import java.util.List;
import com.ToDo.TODO.Entity.Task;


public interface TaskService {
     Task saveTask(Task task);

    void deleteTask (String id);

Task Toggle(String id);
    
    List<Task> getAllTask();
  Task getById(String id);
}
