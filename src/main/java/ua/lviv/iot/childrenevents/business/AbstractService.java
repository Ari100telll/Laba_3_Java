package ua.lviv.iot.childrenevents.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T> {

  protected abstract JpaRepository<T, Integer> getRepository();
  
  public T createObject(T object) {
    return this.getRepository().save(object);
  }

  public T getObject(Integer objectID) {
    return this.getRepository().findById(objectID).orElse(null);
  }

  public List<T> getAllObjects() {
    return this.getRepository().findAll();
  }

  public T updateObject(Integer objectID, T object, T oldObject) {
    T temporaryObject = this.getRepository().findById(objectID).orElse(null);
    if (temporaryObject != null) {
      BeanUtils.copyProperties(temporaryObject, oldObject);
      this.getRepository().save(object);
    }
    return oldObject;
  }

  public T deleteObject(Integer objectID) {
    T oldObject = this.getRepository().findById(objectID).orElse(null);
    if (oldObject != null) {
      this.getRepository().deleteById(objectID);
    }
    return oldObject;
  }

}


