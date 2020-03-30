package ua.lviv.iot.childrenevents.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.childrenevents.dataaccess.ChildrenEventsOptionsRepository;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

@Service
public class ChildrenEventsOptionsService {

  @Autowired
  private ChildrenEventsOptionsRepository childrenEventsOptionsRepository;

  public ChildrenEventsOption createOption(ChildrenEventsOption option) {
    return childrenEventsOptionsRepository.save(option);
  }

  public ChildrenEventsOption getOption(Integer optionID) {
    return childrenEventsOptionsRepository.findById(optionID).get();
  }

  public List<ChildrenEventsOption> getAllOptions() {
    return childrenEventsOptionsRepository.findAll();
  }
  
  public ChildrenEventsOption updateOption(Integer optionID, ChildrenEventsOption option) {
    ChildrenEventsOption oldOption = childrenEventsOptionsRepository.findById(optionID).get();
    if(oldOption != null) {
      childrenEventsOptionsRepository.save(option);
    }
    return oldOption;
  }
  
  public ChildrenEventsOption deleteOption(Integer optionID) {
    ChildrenEventsOption oldOption = childrenEventsOptionsRepository.findById(optionID).get();
    childrenEventsOptionsRepository.deleteById(optionID);
    return oldOption;
  }
}
