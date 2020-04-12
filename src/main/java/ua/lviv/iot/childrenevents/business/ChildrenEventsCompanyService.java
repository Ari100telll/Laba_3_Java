package ua.lviv.iot.childrenevents.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.childrenevents.dataaccess.ChildrenEventsCompanyRepository;
import ua.lviv.iot.childrenevents.model.ChildrenEventsCompany;

@Service
public class ChildrenEventsCompanyService {

  @Autowired
  private ChildrenEventsCompanyRepository childrenEventsCompanyRepository;

  public ChildrenEventsCompany createCompany(ChildrenEventsCompany company) {
    return childrenEventsCompanyRepository.save(company);
  }

  public ChildrenEventsCompany getCompany(Integer companyID) {
    return childrenEventsCompanyRepository.findById(companyID).orElse(null);
  }

  public List<ChildrenEventsCompany> getAllCompanies() {
    return childrenEventsCompanyRepository.findAll();
  }

  public ChildrenEventsCompany updateCompany(Integer companyID, ChildrenEventsCompany company) {
    ChildrenEventsCompany oldCompany = null;
    ChildrenEventsCompany temporarTown = childrenEventsCompanyRepository.findById(companyID).orElse(null);
    if (temporarTown != null) {
      oldCompany = new ChildrenEventsCompany();
      BeanUtils.copyProperties(temporarTown, oldCompany);
      childrenEventsCompanyRepository.save(company);
    }
    return oldCompany;
  }

  public ChildrenEventsCompany deleteCompany(Integer companyID) {
    ChildrenEventsCompany oldCompany = childrenEventsCompanyRepository.findById(companyID).orElse(null);
    if (oldCompany != null) {
      childrenEventsCompanyRepository.deleteById(companyID);
    }
    return oldCompany;
  }

  public int getLastID() {
    List<ChildrenEventsCompany> companies = childrenEventsCompanyRepository.findAll();
    int companiesSize = companies.size();
    return companiesSize > 0 ? companies.get(companiesSize - 1).getId() : 0;
  }

}
