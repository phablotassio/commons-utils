package com.commons.utils.object;

import com.commons.utils.enumns.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;

import java.beans.FeatureDescriptor;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ObjectUtils {

    private ObjectUtils() {
    }

    public static void applyChangesOnObject(Object source, Object target) {

        if (source == null || target == null){
            throw new IllegalArgumentException(Message.OBJECTS_CANNOT_BE_NULL.getMessage());
        }

        if(target.getClass() != source.getClass()){
            throw new IllegalArgumentException(Message.OBJECTS_SAME_INTANCE.getMessage());
        }

        BeanWrapper srcWrap = PropertyAccessorFactory.forBeanPropertyAccess(source);
        BeanWrapper destWrap = PropertyAccessorFactory.forBeanPropertyAccess(target);
        destWrap.setAutoGrowNestedPaths(true);

        final List<String> fieldNames = Stream.of(srcWrap.getPropertyDescriptors()).map(FeatureDescriptor::getName).filter(propertyName -> !propertyName.equals("class")).collect(toList());

        for (String property : fieldNames) {
            final Object srcWrapPropertyValue = srcWrap.getPropertyValue(property);
            if (srcWrapPropertyValue instanceof Collection<?>) {
                continue;
            }

            if (!isWrapperType(srcWrapPropertyValue.getClass())) {
                BeanUtils.copyProperties(srcWrapPropertyValue, destWrap.getPropertyValue(property), getNullPropertyNames(srcWrapPropertyValue));
            } else {
                destWrap.setPropertyValue(property, srcWrap.getPropertyValue(property));

            }

        }

    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }


    private static boolean isWrapperType(Class<?> clazz) {
        return clazz.equals(Boolean.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(String.class);
    }


}
