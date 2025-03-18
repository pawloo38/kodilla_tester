package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskListDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListTest {

    @Autowired
    private TaskListRepository taskListRepository;

    @Test
    void testTaskListRepository() {
        // Given
        TaskListDetails taskList = new TaskListDetails("ToDo", "Tasks to do");

        // When
        taskListRepository.save(taskList);

        // Then
        int id = taskList.getId();
        Optional<TaskListDetails> readTaskList = taskListRepository.findById(id);
        assertTrue(readTaskList.isPresent());

        // CleanUp
        taskListRepository.deleteById(id);
    }
}