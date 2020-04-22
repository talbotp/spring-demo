package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

  private AtomicLong id = new AtomicLong();

  @RequestMapping("/")
  public String hello() {
    long requestId = id.incrementAndGet();
    logger.info("Accepted request" + requestId + " in HelloController");
    return "Wassup dude";
  }

}
