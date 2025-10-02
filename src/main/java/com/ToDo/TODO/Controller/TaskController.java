package com.ToDo.TODO.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ToDo.TODO.Entity.Task;
import com.ToDo.TODO.Service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> savetask(@RequestBody Task task) {

        Task sTask = this.taskService.saveTask(task);
        return ResponseEntity.ok(sTask);

    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getById(@PathVariable("id") String id) {
        Task task = this.taskService.getById(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(task);

        }
        return ResponseEntity.ok().body(task);

    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {

        List<Task> list = this.taskService.getAllTask();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> getToggle(@PathVariable("id") String id) {

        Task task = this.taskService.Toggle(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no exits of  task in DB");

        }

        return ResponseEntity.ok().body(task);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> getDeleted(@PathVariable("id") String id) {
        this.taskService.deleteTask(id);
        return ResponseEntity.ok("Deleted Successfully");

    }

}
