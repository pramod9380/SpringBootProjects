package com.example.exam.controller;

import com.example.exam.Model.Task;
import com.example.exam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("task/{taskid}")
    private Task getTasks(@PathVariable("taskid") int taskid){
        return taskService.getTaskById(taskid);
    }

    @PutMapping("/task/{id}")
    private Task update(@RequestBody Task task,int id)
    {
        System.out.println("id:"+id);
        taskService.update(task,id);
        return task;
    }
}
