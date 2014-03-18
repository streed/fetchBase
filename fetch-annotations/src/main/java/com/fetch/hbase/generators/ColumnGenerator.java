package com.fetch.hbase.generators;

import java.lang.reflect.Method;

import org.apache.commons.lang.WordUtils;

import java.lang.NoSuchMethodException;

public class ColumnGenerator {
  private final String fieldName;
  private final Method getter;
  private final Object obj;

  public ColumnGenerator( Object obj, String field ) throws NoSuchMethodException {
    fieldName = field;
    getter = obj.getClass().getMethod( makeGetterName( field ) ); 
    this.obj = obj;
  }

  private String makeGetterName( String f ) {
    f = "get" + f;
    return WordUtils.capitalizeFully( f );
  }
}
