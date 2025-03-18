package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskListDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskListRepository extends CrudRepository<TaskListDetails, Integer> {
    List<TaskListDetails> findByListName(String listName);
}
