package ua.lviv.iot.childrenevents.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.childrenevents.model.EventTown;

@Repository
public interface EventTownRepository extends JpaRepository<EventTown, Integer> {

}
