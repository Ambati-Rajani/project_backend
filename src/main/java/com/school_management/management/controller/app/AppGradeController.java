package com.school_management.management.controller.app;

import com.school_management.management.helpers.ResponseHelper;
import com.school_management.management.model.Grades;
import com.school_management.management.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app/grades")
public class AppGradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    public ResponseEntity<Object> addStudentGrade(@RequestBody Grades body) {
        try {
            gradeService.addGrade(body);
            return ResponseHelper.createResponse(HttpStatus.OK, "Grade added successfully.", true, null);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), false, null);
        }
    }

    @PutMapping("/{gradeId}")
    public ResponseEntity<Object> updateGrade(@PathVariable String gradeId,@RequestBody Grades body) {
        try {
            gradeService.updateGrade(gradeId,body);
            return ResponseHelper.createResponse(HttpStatus.OK, "Grade added successfully.", true, null);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), false, null);
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Object> getGradesByStudent(@PathVariable String studentId) {
        try {
            List<Grades> data = gradeService.getGradesByStudentId(studentId);
            return ResponseHelper.createResponse(HttpStatus.OK, "Grade added successfully.", data, null);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), false, null);
        }
    }
}
