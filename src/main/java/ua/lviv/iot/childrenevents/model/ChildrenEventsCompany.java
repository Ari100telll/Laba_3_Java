package ua.lviv.iot.childrenevents.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ChildrenEventsCompany {
  @Id
  private Integer id;

  private String name;
  
  @ManyToMany(fetch = FetchType.EAGER)
  @JsonIgnoreProperties({"childrenEventsCompanies"})
  @JoinTable(name = "Companies_Towns", joinColumns = {
      @JoinColumn(name = "company_id", nullable = false) }, inverseJoinColumns = {
          @JoinColumn(name = "town_id", nullable = false) })
  private Set<EventTown> eventTowns;
  
  
  
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "children_events_company_id")
  @JsonIgnoreProperties("childrenEventsCompany")
  private Set<ChildrenEventsOption> companyOptions;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  

  public ChildrenEventsCompany() {
    super();
  }

  public Set<EventTown> getEventTowns() {
    return eventTowns;
  }

  public void setEventTowns(Set<EventTown> eventTowns) {
    this.eventTowns = eventTowns;
  }

  public Set<ChildrenEventsOption> getCompanyOptions() {
    return companyOptions;
  }

  public void setCompanyOptions(Set<ChildrenEventsOption> companyOptions) {
    this.companyOptions = companyOptions;
  }
}
