package com.nuhkoca.offlineapp.di.qualifier

import javax.inject.Scope

/**
 * A scope for DataBinding classes.
 *
 * @author nuhkoca
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class DataBinding
