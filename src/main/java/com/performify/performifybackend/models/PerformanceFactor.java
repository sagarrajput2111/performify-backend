package com.performify.performifybackend.models;

import jakarta.persistence.*;

@Entity
public class PerformanceFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Name of the factor (e.g., "Discipline", "Attendance")
    private String description;  // Description of the factor (optional)
    private boolean isDefault;  // Flag indicating whether it's a default factor or custom

    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;

    public PerformanceFactor() {
    }

    public PerformanceFactor(String name, String description, boolean isDefault, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.isDefault = isDefault;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
