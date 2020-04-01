package ua.lviv.iot.childrenevents.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

@Repository
public interface ChildrenEventsOptionsRepository extends JpaRepository<ChildrenEventsOption, Integer> {
}
