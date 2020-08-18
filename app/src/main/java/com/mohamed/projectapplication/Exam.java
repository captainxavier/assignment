package com.mohamed.projectapplication;

import java.io.Serializable;
import java.util.List;

public class Exam implements Serializable {

   private String userId;
   private List<String> exam;

    public Exam() {
    }

    public Exam(String userId, List<String> exam) {
        this.userId = userId;
        this.exam = exam;
    }
}
