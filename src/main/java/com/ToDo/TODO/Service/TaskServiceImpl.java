package com.ToDo.TODO.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ToDo.TODO.Entity.Task;
import com.ToDo.TODO.Exception.ResourcNotFoundException;
import com.ToDo.TODO.Repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
      if(task.getId()==null){
        String id = UUID.randomUUID().toString();
        task.setId(id);
        task.setInsertAt(new Date());

      }
      
  
   
        Task sTask = this.taskRepository.save(task);
        return sTask;
    }

    @Override
    public void deleteTask(String id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new ResourcNotFoundException("Task not found"));
        this.taskRepository.delete(task);
    }

    @Override
    public Task Toggle(String id) {
     Task task = this.taskRepository.findById(id).orElse(null);
       if (task==null) {
        return null;
        
       }
   
if( task.getCompleted()==false){
    task.setCompleted(true);
}
else{
    task.setCompleted(false);
}
    Task sTask=this.taskRepository.save(task);


        return sTask;
    }

    @Override
    public List<Task> getAllTask() {
        List<Task> list = this.taskRepository.findAll();
        return list;
    }

    @Override
    public Task getById(String id) {
       Task task= this.taskRepository.findById(id).orElse(null);

      return task;
    }

}
