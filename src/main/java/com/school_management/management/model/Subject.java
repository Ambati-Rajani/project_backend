package com.school_management.management.model;

import org.springframework.data.annotation.Id;

public class Subject {

    @Id
    private String subjectId;
    private String name;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
