package app.controllers;

import app.controllers.dto.DTO;
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
public abstract class RESTController<D extends DTO, S extends AbstractService<?, D, ?, ?>> {


    @Autowired
    protected S Service;

    @GetMapping
    public List<D> findAll() {
        return Service.findAll();
    }
    @GetMapping("/{id}")
    public Optional<D> getBy(@PathVariable("id") Long id) {
        return Service.findBy(id);
    }
    @PostMapping
    public D save(@RequestBody D inputAcc ) {
        try{
            Service.save(inputAcc);
            return inputAcc;
        }catch (Exception ex){
            return null;
        }
    }
    @PutMapping("/{id}")
    public D edit(@PathVariable("id") String id,   D edited) {

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
