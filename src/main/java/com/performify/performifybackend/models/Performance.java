package com.performify.performifybackend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;  // Many-to-One relationship with Student

    @ManyToOne
    @JoinColumn(name = "performance_factor_id", nullable = false)
    private PerformanceFactor performanceFactor;  // Many-to-One relationship with PerformanceFactor

    private Integer score;  // Performance score (e.g., 1 to 10)

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher ratedBy;  // Many-to-One relationship with Teacher who rated the performance

    private LocalDate evaluationDate;  // Date of evaluation

    public Performance() {
    }

    public Performance(Student student, PerformanceFactor performanceFactor, Integer score, Teacher ratedBy, LocalDate evaluationDate) {
        this.student = student;
        this.performanceFactor = performanceFactor;
        this.score = score;
        this.ratedBy = ratedBy;
        this.evaluationDate = evaluationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PerformanceFactor getPerformanceFactor() {
        return performanceFactor;
    }

    public void setPerformanceFactor(PerformanceFactor performanceFactor) {
        this.performanceFactor = performanceFactor;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Teacher getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(Teacher ratedBy) {
        this.ratedBy = ratedBy;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
