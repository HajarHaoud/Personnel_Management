package com.mstrsi.pers_management.services;



import com.mstrsi.pers_management.dtos.PosteDto;

import java.util.List;

public interface PosteService {


      PosteDto createPoste(PosteDto poste);
      PosteDto updatePoste(long id , PosteDto posteDto);
      PosteDto deletePoste(long id);
      PosteDto getPosteById(long id);
      List<PosteDto> getAllPostes();
}
