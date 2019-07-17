package com.kurczyna.extension

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.extension.ExtensionAnnotation
import org.spockframework.runtime.model.SpecInfo

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.METHOD])
@ExtensionAnnotation(EmptyH2Extension)
@interface EmptyH2 {}

class EmptyH2Extension extends AbstractAnnotationDrivenExtension<EmptyH2> {

    @Override
    void visitSpecAnnotation(EmptyH2 annotation, SpecInfo specInfo) {}

    @Override
    void visitSpec(SpecInfo spec) {
        spec.addListener(new EmptyH2Listener())
    }
}

class EmptyH2Listener extends AbstractRunListener {

    @Override
    void beforeSpec(SpecInfo spec) {
        TruncateH2TablesScript.execute()
    }
}

class TruncateH2TablesScript {

    static void execute() {
        // your logic for truncating H2 tables
    }
}
