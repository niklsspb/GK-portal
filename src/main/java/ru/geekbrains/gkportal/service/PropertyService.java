package ru.geekbrains.gkportal.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.Property;
import ru.geekbrains.gkportal.entity.PropertyType;
import ru.geekbrains.gkportal.repository.PropertiesRepository;

import javax.transaction.Transactional;


@Service
/** Сервис для работы со свойствами
 * Свойства определяются именем и типом
 * значение - текст
 *
 */
public class PropertyService {

    private static final Logger logger = Logger.getLogger(PropertyService.class);

    private PropertiesRepository propertiesRepository;

    @Autowired
    public void setPropertiesRepository(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    /**
     * Возвращает значение заданного свойства
     * если свойство не существует, то null
     *
     * @param propertyName имя св-ва
     * @param type         тип св-ва
     * @return значение или null
     */
    @Transactional
    public @Nullable
    String getPropertyValue(String propertyName, PropertyType type) {
        Property property = propertiesRepository.findByNameAndPropertyType(propertyName, type);
        return (property == null) ? null : property.getValue();
    }

    /** Устанавливает значение заданного свойства
     *  если св-во не существует, то оно создаётся
     * @param propertyName имя св-ва
     * @param value значение
     * @param type тип св-ва
     */
    @Transactional
    public void setPropertyValue(String propertyName, String value, PropertyType type) {
        Property property = propertiesRepository.findByNameAndPropertyType(propertyName, type);
        if (property == null) property = new Property(propertyName, value, type);
        else property.setValue(value);
        propertiesRepository.save(property);
    }

    /**
     * Удаляет заданное свойство
     *
     * @param propertyName имя св-ва
     * @param type         тип св-ва
     */
    @Transactional
    public int deleteProperty(String propertyName, PropertyType type) {
        return propertiesRepository.deleteAllByNameAndPropertyType(propertyName,type);
    }
}