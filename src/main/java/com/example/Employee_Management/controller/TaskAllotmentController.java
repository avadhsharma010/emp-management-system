package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.TaskAllotmentService;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.TaskAllotmentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/taskallotment")
public class TaskAllotmentController {
@Autowired
    private TaskAllotmentService taskAllotmentService;

    @PostMapping
    public ResponseEntity<String> createTaskAllotment(@RequestBody TaskAllotmentCreateRequest request) {
        taskAllotmentService.createTaskAllotment(request);
        return ResponseEntity.ok("Created");
    }
    @GetMapping
    private List<TaskAllotment> getAll()
    {
        return taskAllotmentService.getAll();
    }
    @DeleteMapping
    private void DeleteAllProject() {
        taskAllotmentService.deleteAll();
    }
    @GetMapping("/{id}")
    public TaskAllotment getTaskAllotmentByID(@PathVariable Integer id){
        return taskAllotmentService.getTaskAllotmentByID(id);
    }
    @DeleteMapping("/{id}")
    private void DeleteTaskAllotment(@PathVariable Integer id){
        taskAllotmentService.deleteByID(id);
    }
    @PutMapping("/{id}")
    private void changeTaskAllotment(@PathVariable Integer id,@RequestBody TaskAllotment taskAllotment){
        taskAllotmentService.update(taskAllotment,id);
    }
}
