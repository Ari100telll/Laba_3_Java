package ua.lviv.iot.childrenevents.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
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
import ua.lviv.iot.childrenevents.business.ChildrenEventsOptionsService;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

@RestController
@RequestMapping(path = "/ChildrenEventsOptions")
public class ChildrenEventsOptionsController {
  private AtomicInteger idCounter = new AtomicInteger();
  @Autowired
  private ChildrenEventsOptionsService childrenEventsOptionsService;

  @GetMapping
  public List<ChildrenEventsOption> getOptions() {
    return childrenEventsOptionsService.getAllOptions();
  }

  @GetMapping(path = "/{id}")
  public ChildrenEventsOption getOption(final @PathVariable("id") Integer optionID) {
    return childrenEventsOptionsService.getOption(optionID);
  }

  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, "application/x-yaml" })
  public ChildrenEventsOption addOption(final @RequestBody ChildrenEventsOption option) {
    option.setId(idCounter.incrementAndGet());
    childrenEventsOptionsService.createOption(option);
    return option;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ChildrenEventsOption> deleteOption(@PathVariable("id") Integer optionID) {
    return childrenEventsOptionsService.deleteOption(optionID) == null
        ? new ResponseEntity<ChildrenEventsOption>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<ChildrenEventsOption>(HttpStatus.OK);
  }

  @PutMapping(path = { "/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<ChildrenEventsOption> updateOption(@PathVariable("id") Integer optionID,
      @RequestBody ChildrenEventsOption option) {
    option.setId(optionID);
    ChildrenEventsOption oldOption = childrenEventsOptionsService.updateOption(optionID, option);
    return oldOption == null ? new ResponseEntity<ChildrenEventsOption>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<ChildrenEventsOption>(oldOption, HttpStatus.OK);
  }
}
