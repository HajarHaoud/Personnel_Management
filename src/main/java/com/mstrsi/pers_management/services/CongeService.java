package com.mstrsi.pers_management.services;



import com.mstrsi.pers_management.dtos.CongeDto;

import java.util.List;

public interface CongeService {
    CongeDto createConge(CongeDto conge);
    CongeDto updateConge(long id , CongeDto congeDto);
    CongeDto deleteConge(long id);
    CongeDto getCongeById(long id);
    List<CongeDto> getAllConges();
}
