package com.wjm.postgers.handler;

import com.wjm.postgers.exception.WjmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(value = WjmException.class)
    public ResponseEntity girlExceptionHandler(WjmException e) {
        log.info("Girl相关异常 => {}",e.getMessage());
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity runtimeExceptionHandler(RuntimeException e) {
        //log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}