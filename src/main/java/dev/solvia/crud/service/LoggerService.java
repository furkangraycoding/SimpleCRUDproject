package dev.solvia.crud.service;



import dev.solvia.crud.model.Logger;
import dev.solvia.crud.repository.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LoggerService {


    private final LoggerRepository loggerRepository;

    @Transactional
    public Logger save(Logger logger) {
        Logger loggerSave=new Logger();
        loggerSave.setThrowMessage(logger.getThrowMessage());
        loggerSave.setThrowDate(logger.getThrowDate());
        loggerSave.setThrowStatusCode(logger.getThrowStatusCode());
        return loggerRepository.save(loggerSave);
    }

}
