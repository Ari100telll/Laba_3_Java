package ua.lviv.iot.childrenevents.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.childrenevents.dataaccess.EventTownRepository;
import ua.lviv.iot.childrenevents.model.EventTown;

@Service
public class EventTownService {
  @Autowired
  private EventTownRepository eventTownRepository;
  

  public EventTown createTown(EventTown town) {
    return eventTownRepository.save(town);
  }

  public EventTown getTown(Integer townID) {
    return eventTownRepository.findById(townID).orElse(null);
  }

  public List<EventTown> getAllTowns() {
    return eventTownRepository.findAll();
  }

  public EventTown updateTown(Integer townID, EventTown town) {
    EventTown oldTown = null;
    EventTown temporarTown = eventTownRepository.findById(townID).orElse(null);
    if (temporarTown != null) {
      oldTown = new EventTown();
      BeanUtils.copyProperties(temporarTown, oldTown);
      eventTownRepository.save(town);
    }
    return oldTown;
  }

  public EventTown deleteTown(Integer townID) {
    EventTown oldTown = eventTownRepository.findById(townID).orElse(null);
    if (oldTown != null) {
      eventTownRepository.deleteById(townID);
    }
    return oldTown;
  }
  
}
