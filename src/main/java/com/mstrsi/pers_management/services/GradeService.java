package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.GradeDto;


import java.util.List;

public interface GradeService {
    GradeDto createGrade(GradeDto grade);
    GradeDto updateGrade(long id , GradeDto gradeDto);
    GradeDto deleteGrade(long id);
    GradeDto getGradeById(long id);
    List<GradeDto> getAllGrades();
}
