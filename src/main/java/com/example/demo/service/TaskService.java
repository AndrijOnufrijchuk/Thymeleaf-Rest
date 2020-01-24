package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Task;
import com.example.demo.vo.TaskVo;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;
    public List<TaskVo> getTaskList() {
        return repository.findAll().stream().map(u -> {
            TaskVo vo = new TaskVo();
            vo.setId(u.getId());
            vo.setName(u.getName());
            vo.setEmail(u.getEmail());
            return vo;
        }).collect(Collectors.toList());
    }
    public TaskVo getTaskById(String id) {
        return repository.findById(id).map(u -> {
            TaskVo vo = new TaskVo();
            vo.setId(u.getId());
            vo.setName(u.getName());
            vo.setEmail(u.getEmail());
            return vo;
        }).orElse(null);
    }
    public void saveTask(TaskVo vo) {
        Task task = new Task();
        task.setName(vo.getName());
        task.setEmail(vo.getEmail());
        task.setPwd(vo.getPwd());
        repository.save(task);
    }
    public void updateTask(TaskVo vo) {
        Task task = new Task();
        task.setId(vo.getId());
        task.setName(vo.getName());
        task.setEmail(vo.getEmail());
        task.setPwd(vo.getPwd());
        repository.save(task);
    }
    public void deleteTask(TaskVo vo) {
        Task task = new Task();
        task.setId(vo.getId());
        repository.delete(task);
    }
}
