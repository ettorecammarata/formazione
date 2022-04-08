package com.besidetech.training.controller.logger;

import com.besidetech.training.controller.AbstractResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(RestResources.ROOT)
    public String info (String message) {
//        logger.trace(AbstractResponse.LOG_TRACE + message);
//        logger.debug(AbstractResponse.LOG_DEBUG  + message);
        logger.info(AbstractResponse.LOG_INFO + message);
//        logger.warn(AbstractResponse.LOG_WARN + message);
//        logger.error(AbstractResponse.LOG_ERROR + message);
        return AbstractResponse.LOG_WELCOME;
    }
}
