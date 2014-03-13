package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.Table;
import com.fetch.hbase.annotations.ColumnFamily;
import com.fetch.hbase.annotations.exceptions.FetchColumnFamilyException;

import java.util.Set;
import java.util.HashSet;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ColumnFamilyParser {
  public static Set<String> getColumnFamilies( Class klass ) throws FetchColumnFamilyException {
    Set<String> familyNames = new HashSet();
    if( klass.isAnnotationPresent( Table.class ) ) {
      Field [] fields = klass.getDeclaredFields();

      for( Field f: fields ) {
        Annotation annotation = f.getAnnotation( ColumnFamily.class );
        ColumnFamily cf = (ColumnFamily)annotation;
        if( cf != null ) {
          familyNames.add( cf.family() );
        }
      }
    }

    return familyNames;
  }
}
