package app.controllers;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.services.AbstractService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
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
@Log
public abstract class RESTController<I extends RequestDTO,
                                     O extends ResponseDTO,
                                     S extends AbstractService<I, O>> {

    @Autowired
    protected S service;
    /**
     * Метод, срабатывающтй при GET запросе, с путём ../../
     * @return  Возвращает  список экземпляров {@link O}
     */
    @GetMapping
    public List<O> findAll() {
        return service.findAll();
    }
    /**
     * Метод, срабатывающтй при GET запросе, с путём ../../{id}
     * @param id - ID объекта
     * @return Возвращает экземпляров {@link O} по заданному id
     */
    @GetMapping("/{id}")
    public Optional<O> getBy(@PathVariable("id") Long id) {
        return service.find(id);
    }
    /**
     * Метод, срабатывающтй при POST запросе, с путём ../../{id}
     * @param inputAcc - Экзмепляр {@link I} с даннми для загрузки в БД
     * @return В случае успеха возвращает экземпляр inputAcc, иначе null
     */
    @PostMapping
    public I save(@RequestBody I inputAcc ) {
        try{
            service.create(inputAcc);
        }catch (Exception ex){
            log.warning("Save failed, cause: " + ex.getMessage());
        }
        return inputAcc;
    }
    /**
     * Метод, срабатывающтй при PUT запросе, с путём ../../{id}
     * @param id - ID сущности, в которорй необходимы изменения
     * @param edited - эксемпляр {@link I}, с отредактированными данными для загрузки в БД
     * @return В случае успеха возвращает экземпляр inputAcc, иначе null
     */
    @PutMapping("/{id}")
    public I edit(@PathVariable("id") Long id, @RequestBody I edited) {

        try{
            service.update(edited);
            log.info("Editing... " + edited.toString());
        } catch (IllegalArgumentException ex){
            log.warning("Edit failed, cause: " + ex.getMessage());
        }
        return edited;

    }
    /**
     * Метод, срабатывающтй при DELETE запросе, с путём ../../{id}
     * @param id - ID сущности, в которую необходимо удалить
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        try{
            service.delete(id);
            log.info("Delete by id = " + id);
        }catch(IllegalArgumentException ex){
            log.warning("Delete failed, cause: " + ex.getMessage());
        }
    }

}
