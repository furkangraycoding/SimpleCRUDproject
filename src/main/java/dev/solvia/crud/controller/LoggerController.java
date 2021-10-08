package dev.solvia.crud.controller;


import dev.solvia.crud.model.Logger;
import dev.solvia.crud.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class LoggerController {

     LoggerService loggerService;


    @Autowired
    public LoggerController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @PostMapping("/logs")
    public Logger saveLogs(@RequestBody Logger logger){
        return loggerService.save(logger);

    }


}
