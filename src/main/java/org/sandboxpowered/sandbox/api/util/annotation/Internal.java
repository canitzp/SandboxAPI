package org.sandboxpowered.sandbox.api.util.annotation;

import java.lang.annotation.*;

/**
 * APIs in this state will have the term internal prominently displayed in their documentation as well as the annotation @Internal. In some cases the term internal also appears in their namespace, comments, or as a prefix to each method name.
 * Does not adhere to our bug fixing or breaking change policies. Should never be used outside of the API or Implementations
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
public @interface Internal {
}
