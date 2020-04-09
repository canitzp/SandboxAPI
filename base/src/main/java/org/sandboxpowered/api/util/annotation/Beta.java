package org.sandboxpowered.api.util.annotation;

import java.lang.annotation.*;

/**
 * Feature complete and potentially with some performance optimisation, but may still be slightly unstable. APIs in this state will have the term beta prominently displayed in their documentation as well as the annotation @Beta. In some cases the term beta also appears in their namespace, comments, or as a prefix to each method name.
 * Does not adhere to our bug fixing or breaking change policies. Available for development, but not recommended for public releases.
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
public @interface Beta {
}
