package double_example.restrictions;

import hu.unideb.czty.analyzer.restrictions.core.RestrictionAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestrictionAnnotation(value = DirectParentRestriction.class)
public @interface DirectParent {
    String[] names();
}
