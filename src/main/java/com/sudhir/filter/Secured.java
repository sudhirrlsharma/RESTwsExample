package com.sudhir.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Secured { }
