package double_example.restrictions;

import hu.unideb.czty.analyzer.restrictions.core.RestrictionAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RestrictionAnnotation(value = MyRestrictionImpl.class, defaultMessage = "Error!")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyRestriction {

}
