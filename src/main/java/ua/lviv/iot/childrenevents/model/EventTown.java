package ua.lviv.iot.childrenevents.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class EventTown {
  @Id
  private Integer id;
  private String name;
  
  @ManyToMany(fetch = FetchType.EAGER)
  @JsonIgnoreProperties({"eventTowns","companyOptions"})
  @JoinTable(name = "Companies_Towns", joinColumns = {
      @JoinColumn(name = "town_id", nullable = false) }, inverseJoinColumns = {
          @JoinColumn(name = "company_id", nullable = false) })
  private Set<ChildrenEventsCompany> childrenEventsCompanies;

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

  public Set<ChildrenEventsCompany> getChildrenEventsCompanies() {
    return childrenEventsCompanies;
  }

  public void setChildrenEventsCompanies(Set<ChildrenEventsCompany> childrenEventsCompanies) {
    this.childrenEventsCompanies = childrenEventsCompanies;
  }

  public EventTown() {
    super();
  }
}
