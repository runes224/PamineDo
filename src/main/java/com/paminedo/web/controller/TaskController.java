package com.paminedo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paminedo.domain.Task;
import com.paminedo.domain.TaskRepository;

@RestController
class TaskController {

  @Autowired
  TaskRepository repository;

  @GetMapping("/tasks")
  List<Task> all() {
    return repository.findAll();
  }

  @PostMapping("/tasks")
  Task newTask(Task newTask) {
    return repository.save(newTask);
  }

  @GetMapping("/tasks/{id}")
  Task one(@PathVariable Long id) {

    return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
  }

  @PutMapping("/tasks/{id}")
  Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

    return repository.findById(id).map(Task -> {
      Task.setName(newTask.getName());
      Task.setDescription(newTask.getDescription());
      Task.setCompletedFlag(newTask.isCompletedFlag());
      Task.setRegularTaskFlag(newTask.isRegularTaskFlag());
      Task.setCompletedDate(newTask.getCompletedDate());
      return repository.save(Task);
    }).orElseGet(() -> {
      newTask.setId(id);
      return repository.save(newTask);
    });
  }

  @DeleteMapping("/tasks/{id}")
  void deleteTask(@PathVariable Long id) {
    repository.deleteById(id);
  }

  class TaskNotFoundException extends RuntimeException {

    TaskNotFoundException(Long id) {
      super("Could not find task " + id);
    }
  }
}