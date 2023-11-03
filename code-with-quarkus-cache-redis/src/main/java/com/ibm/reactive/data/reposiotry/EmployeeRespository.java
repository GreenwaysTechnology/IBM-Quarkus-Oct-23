package com.ibm.reactive.data.reposiotry;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRespository implements PanacheRepository<Employee> {

}
