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

import ua.lviv.iot.childrenevents.business.EventTownService;
import ua.lviv.iot.childrenevents.model.EventTown;

@RestController
@RequestMapping(path = "/EventTowns")
public class EventTownController {

  @Autowired
  private EventTownService eventTownService;

  private AtomicInteger id = new AtomicInteger();

  @GetMapping
  public List<EventTown> getTowns() {
    return eventTownService.getAllTowns();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<EventTown> getTown(final @PathVariable("id") Integer townID) {
    EventTown town = eventTownService.getTown(townID);
    return town == null ? new ResponseEntity<EventTown>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<EventTown>(town, HttpStatus.OK);
  }

  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, "application/x-yaml" })
  public synchronized EventTown addTown(final @RequestBody EventTown town) {
    town.setId(id.incrementAndGet());
    System.out.println(eventTownService.getLastID());
    eventTownService.createTown(town);
    return town;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<EventTown> deleteTown(@PathVariable("id") Integer townID) {
    return eventTownService.deleteTown(townID) == null ? new ResponseEntity<EventTown>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<EventTown>(HttpStatus.OK);
  }

  @PutMapping(path = { "/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<EventTown> updateTown(@PathVariable("id") Integer townID, @RequestBody EventTown town) {
    town.setId(townID);
    EventTown oldTown = eventTownService.updateTown(townID, town);
    return oldTown == null ? new ResponseEntity<EventTown>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<EventTown>(oldTown, HttpStatus.OK);
  }
}
