package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.Table;
import com.fetch.hbase.annotations.ColumnFamily;
import com.fetch.hbase.annotations.exceptions.FetchColumnFamilyException;

import java.util.Set;
import java.util.HashSet;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ColumnFamilyParser {
  private static final String DEFAULT = "fetchDefault";

  public static String getColumnFamilies( Class klass ) throws FetchColumnFamilyException {
    Set<String> familyNames = new HashSet();
    if( klass.isAnnotationPresent( Table.class ) ) {
      if( klass.isAnnotationPresent( ColumnFamily.class ) ) {
        Annotation annotation = klass.getAnnotation( ColumnFamily.class );
        ColumnFamily cf = (ColumnFamily)annotation;

        //familyNames.add( cf.family() );
        return cf.family();
      }

      /*Field [] fields = klass.getDeclaredFields();

      for( Field f: fields ) {
        Annotation annotation = f.getAnnotation( ColumnFamily.class );
        ColumnFamily cf = (ColumnFamily)annotation;
        if( cf != null ) {
          familyNames.add( cf.family() );
        }
      }
    }*/
    }

    return DEFAULT;
  }
}
