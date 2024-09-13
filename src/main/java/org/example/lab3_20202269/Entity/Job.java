package org.example.lab3_20202269.Entity;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "job_title")
    private String jobTitle;
}
