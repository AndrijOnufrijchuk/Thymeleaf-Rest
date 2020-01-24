package com.example.demo.controller;

import java.util.List;

import com.example.demo.vo.TaskVo;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRestController {
    @Autowired
    private TaskService service;
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskVo> getTask(@PathVariable String id) {
        return new ResponseEntity<>(service.getTaskById(id), HttpStatus.OK);
    }
    @GetMapping("/task")
    public ResponseEntity<List<TaskVo>> getTaskList() {
        return new ResponseEntity<>(service.getTaskList(), HttpStatus.OK);
    }
    @PostMapping("/task")
    public ResponseEntity<String> saveTask(@RequestBody TaskVo TaskVo) {
        service.saveTask(TaskVo);
        return new ResponseEntity<>("New Task successfully saved", HttpStatus.OK);
    }
    @PutMapping("/task")
    public ResponseEntity<String> updateTask(@RequestBody TaskVo TaskVo) {
        service.updateTask(TaskVo);
        return new ResponseEntity<>("Task successfully updated", HttpStatus.OK);
    }
    @DeleteMapping("/task")
    public ResponseEntity<String> deleteTask(@RequestBody TaskVo taskVo) {
        service.deleteTask(taskVo);
        return new ResponseEntity<>("Task successfully deleted", HttpStatus.OK);
    }
}