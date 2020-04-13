package ua.lviv.iot.childrenevents.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.childrenevents.dataaccess.ChildrenEventsCompanyRepository;
import ua.lviv.iot.childrenevents.model.ChildrenEventsCompany;

@Service
public class ChildrenEventsCompanyService extends AbstractService<ChildrenEventsCompany>{

  @Autowired
  private ChildrenEventsCompanyRepository childrenEventsCompanyRepository;

  @Override
  protected JpaRepository<ChildrenEventsCompany, Integer> getRepository() {
    return childrenEventsCompanyRepository;
  }

}
