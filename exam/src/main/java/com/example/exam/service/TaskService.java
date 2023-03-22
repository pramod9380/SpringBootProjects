package com.example.exam.service;

import com.example.exam.Model.Task;
import com.example.exam.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task getTaskById(int id)
    {
        return taskRepository.findById(id).get();
    }

    public void update(Task task,int id)
    {
        Task task1 = taskRepository.findById(id).get();
        if(task1.getId()==id){
            taskRepository.save(task);
        }
    }
}
