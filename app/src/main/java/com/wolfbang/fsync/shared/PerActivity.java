package com.wolfbang.fsync.shared;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chris on 12/04/2015.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}