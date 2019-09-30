package org.sandboxpowered.sandbox.api.util.annotation;

import java.lang.annotation.*;

/**
 * Feature incomplete. Unknown if will become stable. APIs in this state will have the term prealpha prominently displayed in their documentation as well as the annotation @PreAlpha. In some cases the term prealpha also appears in their namespace, comments, or as a prefix to each method name.
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
public @interface PreAlpha {
}
