package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.Table;
import com.fetch.hbase.annotations.exceptions.FetchTableException;

import java.lang.annotation.Annotation;

public class TableParser {
  public static String getTable( Class klass ) throws FetchTableException {
    if( klass.isAnnotationPresent( Table.class ) ) {
      Annotation annotation = klass.getAnnotation( Table.class );
      Table table = (Table)annotation;
      return table.name();
    } else {
      throw new FetchTableException( "Class passed in with out annotation: " + klass );
    }
  }
}
