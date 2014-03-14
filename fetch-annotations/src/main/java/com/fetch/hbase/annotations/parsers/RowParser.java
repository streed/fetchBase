package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.policy.Policy;
import com.fetch.hbase.annotations.Row;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

//TODO Ensure only one Row is present on the class.
public class RowParser {
  public static Policy.Code getPolicyCode( Class klass ) {
    if( klass.isAnnotationPresent( Row.class ) ) {
      Annotation annotation = klass.getAnnotation( Row.class );
      Row row = (Row)annotation;

      return row.policy();
    }

    return Policy.Code.BASIC;
  }
}
