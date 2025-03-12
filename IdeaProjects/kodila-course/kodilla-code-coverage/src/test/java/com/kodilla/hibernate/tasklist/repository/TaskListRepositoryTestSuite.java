package com.kodilla.hibernate.tasklist.repository;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository;

    private static final String LIST_NAME = "Test List Name";
    private static final String DESCRIPTION = "Test Description";

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
        taskListRepository.save(taskList);

        // When
        List<TaskList> readTaskLists = taskListRepository.findByListName(LIST_NAME);

        // Then
        Assertions.assertEquals(1, readTaskLists.size());
        Assertions.assertEquals(LIST_NAME, readTaskLists.get(0).getListName());
        Assertions.assertEquals(DESCRIPTION, readTaskLists.get(0).getDescription());

        // CleanUp
        int id = readTaskLists.get(0).getId();
        taskListRepository.deleteById(id);
    }
}
