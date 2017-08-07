package com.danijax.cache;

import java.lang.annotation.*;

/**
 * Created by danijax on 8/4/17.
 */
//@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Loggable {
}
