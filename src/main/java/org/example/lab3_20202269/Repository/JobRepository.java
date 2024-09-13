package org.example.lab3_20202269.Repository;

import org.example.lab3_20202269.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    Job findByJobId(String id);
}
