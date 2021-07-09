package app.controllers;

import app.controllers.dto.DTO;
import app.services.AbstractService;

public abstract class RESTController<D extends DTO, S extends AbstractService<?, D, ?, ?>> {

    S service;


}
