package ru.geekbrains.gkportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Property;
import ru.geekbrains.gkportal.entities.PropertyType;

@Repository
public interface PropertiesRepository extends CrudRepository<Property, Long> {

    Property findByNameAndPropertyType(String name, PropertyType type);

}
