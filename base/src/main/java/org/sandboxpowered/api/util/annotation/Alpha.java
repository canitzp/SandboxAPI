package org.sandboxpowered.api.util.annotation;

import java.lang.annotation.*;

/**
 * Feature incomplete and may have some significant bugs. Planned to become stable. APIs in this state will have the term alpha prominently displayed in their documentation as well as the annotation @Alpha. In some cases the term alpha also appears in their namespace, comments, or as a prefix to each method name.
 * Does not adhere to our bug fixing or breaking change policies. Available for testing and development, but not recommended for public releases.
 */
@Retention(RetentionPolicy.CLASS)
@Target({
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE
})
@Documented
public @interface Alpha {
}
