package app.controllers;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.services.AbstractService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
*  Абстрактный контроллер
 *  для обработки обработки запросов
* @author Krll
* */

@AllArgsConstructor
@NoArgsConstructor
public abstract class RESTController<I extends RequestDTO,
                                     O extends ResponseDTO,
                                     S extends AbstractService<?, I, O, ?, ?>> {

    @Autowired
    protected S Service;

    @GetMapping
    public List<O> findAll() {
        return Service.findAll();
    }
    @GetMapping("/{id}")
    public Optional<O> getBy(@PathVariable("id") Long id) {
        return Service.findBy(id);
    }
    @PostMapping
    public I save(@RequestBody I inputAcc ) {
        try{
            Service.save(inputAcc);
            return inputAcc;
        }catch (Exception ex){
            return null;
        }
    }
    @PutMapping("/{id}")
    public I edit(@PathVariable("id") String id, I edited) {

        try{
            Service.save(edited);
            return  edited;
        }catch (IllegalArgumentException ex){
            return null;
        }


    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        try{
            Service.deleteBy(id);

        }catch(IllegalArgumentException ex){
            return;
        }
    }


}
