package com.paminedo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paminedo.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
