package ua.lviv.iot.childrenevents.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.childrenevents.dataaccess.ChildrenEventsOptionsRepository;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

@Service
public class ChildrenEventsOptionsService extends AbstractService<ChildrenEventsOption> {

  @Autowired
  private ChildrenEventsOptionsRepository childrenEventsOptionsRepository;

  @Override
  protected JpaRepository<ChildrenEventsOption, Integer> getRepository() {
    return childrenEventsOptionsRepository;
  }

}
