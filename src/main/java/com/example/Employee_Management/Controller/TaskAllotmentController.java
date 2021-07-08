package com.example.Employee_Management.Controller;

import com.example.Employee_Management.Service.TaskAllotmentService;

import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.TaskAllotmentCreateRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskAllotmentController {
@Autowired
    private TaskAllotmentService taskAllotmentService;

    @PostMapping("/api/v1/TaskAllotment")
    public ResponseEntity<String> createTaskAllotment(@RequestBody TaskAllotmentCreateRequest Request) {
        taskAllotmentService.createTaskAllotment(Request);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/api/v1/TaskAllotment")
    private List<TaskAllotment> getAll()
    {
        return taskAllotmentService.getAll();
    }

    @DeleteMapping("/api/v1/TaskAllotment")
    private void DeleteAllStudent() {
        taskAllotmentService.deleteAll();
    }

    @GetMapping("/api/v1/TaskAllotment/{taskAllotmentid}")
    public ResponseEntity<TaskAllotment>getTaskAllotmentByID(@PathVariable Integer taskAllotmentid){
        return ResponseEntity.ok(taskAllotmentService.getTaskAllotmentByID(taskAllotmentid));
    }

    @DeleteMapping("/api/v1/TaskAllotment/{taskAllotmentid}")
    private void DeleteTaskAllotment(@PathVariable Integer taskAllotmentid){
        taskAllotmentService.deleteByID(taskAllotmentid);
    }

    @PutMapping("api/v1/TaskAllotment/{taskAllotmentid}")
    private void updateTaskAllotment(@PathVariable Integer taslallotmentid ,@RequestBody TaskAllotment taskAllotment2){
        taskAllotmentService.update(taskAllotment2,taslallotmentid);
    }


}
