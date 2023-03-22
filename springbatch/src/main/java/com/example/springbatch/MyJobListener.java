package com.example.springbatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.util.Date;

public class MyJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        //@TODO BEFORE LOGIC
        System.out.println("Stated date and time : "+ new Date());
        System.out.println("Status : "+ jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        // TODO AFTER LOGIC
        System.out.println("Ended date and time : "+ new Date());
        System.out.println("Status : "+ jobExecution.getStatus());
    }
}
