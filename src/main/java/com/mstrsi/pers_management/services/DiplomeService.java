package com.mstrsi.pers_management.services;


import com.mstrsi.pers_management.dtos.DiplomeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DiplomeService {
    DiplomeDto createDiplome(DiplomeDto diplome);
    DiplomeDto updateDiplome(long id , DiplomeDto diplomeDto);
    DiplomeDto deleteDiplome(long id);
    DiplomeDto getDiplomeById(long id);
    List<DiplomeDto> getAllDiplomes();

}
