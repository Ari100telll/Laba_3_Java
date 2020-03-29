package ua.lviv.iot.childrenevents.spring.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

@RestController
@RequestMapping(path = "/ChildrenEventsOptions")

public class ChildrenEventsOptionsController {

  private Map<Integer, ChildrenEventsOption> options = new HashMap<>();
  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<ChildrenEventsOption> getOptions() {
    return new LinkedList<ChildrenEventsOption>(options.values());
  }

  @GetMapping(path = "/{id}")
  public ChildrenEventsOption getOption(final @PathVariable("id") Integer optionID) {
    return options.get(optionID);
  }

  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, "application/x-yaml" })
  public ChildrenEventsOption addOption(final @RequestBody ChildrenEventsOption option) {
    option.setOptionID(idCounter.incrementAndGet());
    options.put(option.getOptionID(), option);
    return option;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ChildrenEventsOption> deleteOption(@PathVariable("id") Integer optionID) {
    HttpStatus status = options.remove(optionID) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = { "/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<ChildrenEventsOption> updateOption(@PathVariable("id") Integer optionID,
      @RequestBody ChildrenEventsOption option) {
    option.setOptionID(optionID);
    System.out.println(option.getOptionID());
    if (options.remove(option.getOptionID()) != null) {
      options.put(option.getOptionID(), option);
      return ResponseEntity.status(HttpStatus.OK).build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
