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

import ua.lviv.iot.childrenevents.business.ChildrenEventsCompanyService;
import ua.lviv.iot.childrenevents.model.ChildrenEventsCompany;

@RestController
@RequestMapping(path = "/ChildrenEventsCompany")
public class ChildrenEventsCompanyController {
  @Autowired
  private ChildrenEventsCompanyService childrenEventsCompanyService;

  private AtomicInteger id = new AtomicInteger();

  @GetMapping
  public List<ChildrenEventsCompany> getCompanys() {
    return childrenEventsCompanyService.getAllCompanies();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ChildrenEventsCompany> getTown(final @PathVariable("id") Integer companyID) {
    ChildrenEventsCompany company = childrenEventsCompanyService.getCompany(companyID);
    return company == null ? new ResponseEntity<ChildrenEventsCompany>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<ChildrenEventsCompany>(company, HttpStatus.OK);
  }

  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, "application/x-yaml" })
  public synchronized ChildrenEventsCompany addTown(final @RequestBody ChildrenEventsCompany company) {
    company.setId(id.incrementAndGet());
    System.out.println(childrenEventsCompanyService.getLastID());
    childrenEventsCompanyService.createCompany(company);
    return company;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ChildrenEventsCompany> deleteTown(@PathVariable("id") Integer companyID) {
    return childrenEventsCompanyService.deleteCompany(companyID) == null
        ? new ResponseEntity<ChildrenEventsCompany>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<ChildrenEventsCompany>(HttpStatus.OK);
  }

  @PutMapping(path = { "/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<ChildrenEventsCompany> updateTown(@PathVariable("id") Integer companyID,
      @RequestBody ChildrenEventsCompany company) {
    company.setId(companyID);
    ChildrenEventsCompany oldCompany = childrenEventsCompanyService.updateCompany(companyID, company);
    return oldCompany == null ? new ResponseEntity<ChildrenEventsCompany>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<ChildrenEventsCompany>(oldCompany, HttpStatus.OK);
  }
}
