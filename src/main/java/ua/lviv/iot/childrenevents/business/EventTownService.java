package ua.lviv.iot.childrenevents.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.childrenevents.dataaccess.EventTownRepository;
import ua.lviv.iot.childrenevents.model.EventTown;

@Service
public class EventTownService extends AbstractService<EventTown> {
  @Autowired
  private EventTownRepository eventTownRepository;

  @Override
  protected JpaRepository<EventTown, Integer> getRepository() {
    return eventTownRepository;
  }

}
