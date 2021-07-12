package app.services;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface AbstractService<I extends RequestDTO, O extends ResponseDTO> {

    O save(I dto);
    List<O> saveAll(List<I> dtoList);
    Optional<O> findBy(Long id);
    List<O> findAll();
    void deleteBy(Long id);
    Boolean exists(Long id);
    Long count();

}
