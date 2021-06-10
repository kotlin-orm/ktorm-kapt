package org.ktorm.kapt.compiler

import com.bennyhuo.aptutils.AptContext
import com.bennyhuo.aptutils.logger.Logger
import com.sun.tools.javac.code.Symbol
import org.ktorm.kapt.KtormTable
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

public class KtormProcessor : AbstractProcessor() {
    public companion object {
        private val supportedAnnotationTypeSet = setOf(KtormTable::class.java.name)
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return supportedAnnotationTypeSet.toMutableSet()
    }

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.RELEASE_8

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        AptContext.init(processingEnv)
    }

    override fun process(annotations: MutableSet<out TypeElement>, env: RoundEnvironment): Boolean {
        //env.rootElements.forEach {
        //    Logger.warn(it, it.simpleName.toString())
        //}
        env.getElementsAnnotatedWith(KtormTable::class.java).asSequence()
            .mapNotNull { it as? TypeElement }
            .forEach { tableElement ->
                Logger.warn(tableElement,
                    "element ${tableElement.simpleName}(${tableElement.javaClass}) annotated by KtormTable")
                tableElement.enclosedElements.asSequence()
                    .mapNotNull { it as? Symbol.VarSymbol }
                    .forEach { columnElement ->
                        columnElement.isPrivate
                        Logger.warn(tableElement,
                            "element ${columnElement.simpleName}(${columnElement.javaClass}) is an column element")
                    }
            }
        return true
    }
}
