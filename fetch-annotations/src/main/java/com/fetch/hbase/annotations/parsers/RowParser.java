package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.policy.Policy;
import com.fetch.hbase.annotations.Row;
import com.fetch.hbase.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

//TODO Ensure only one Row is present on the class.
public class RowParser {
  public static Policy.Code getPolicyCode( Class klass ) {
    Policy.Code code = Policy.Code.BASIC;
    if( klass.isAnnotationPresent( Table.class ) ) {
      Field [] fields = klass.getDeclaredFields();

      for( Field f: fields ) {
        Annotation annotation = f.getAnnotation( Row.class );
        Row row = (Row)annotation;

        if( row != null ) {
          code = row.policy();
          break;
        }
      }
    }

    return code;
  }
}
