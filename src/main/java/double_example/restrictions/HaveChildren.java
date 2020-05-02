package double_example.restrictions;


import hu.unideb.czty.analyzer.restrictions.core.RestrictionAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RestrictionAnnotation(value = HaveChildrenRestriction.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HaveChildren {
    String[] names();
}
