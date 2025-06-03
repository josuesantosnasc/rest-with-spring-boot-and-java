package br.com.joshdev.controllers;

import br.com.joshdev.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/api/test/v1")
    public String testLog(){
        logger.info("This is an INFO Log");
        logger.debug("This is an DEBUG Log");
        logger.warn("This is an WARN Log");
        logger.error("This is an ERROR Log");
        return "Logs generate succssfully";
    }
}
