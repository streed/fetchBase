package com.fetch.hbase.annotations;

import com.fetch.hbase.annotations.exceptions.FetchColumnFamilyException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestColumnFamily {
  @Table( name="test" )
  private class TestKlass {
    @ColumnFamily( family="test" )
    int test;
  }

  @Table( name="test" )
  private class TestKlass2 {
    @ColumnFamily
    int test;
  }

  @Test
  public void test_that_the_column_family_contains_the_proper_name() {
    Field [] fields = TestKlass.class.getDeclaredFields();

    Annotation annotation = fields[0].getAnnotation( ColumnFamily.class );

    ColumnFamily cf = (ColumnFamily)annotation;

    assertEquals( "test", cf.family() );
  }

  @Test
  public void test_that_the_column_family_contains_the_proper_name_from_default_family() {
    Field [] fields = TestKlass2.class.getDeclaredFields();

    Annotation annotation = fields[0].getAnnotation( ColumnFamily.class );

    ColumnFamily cf = (ColumnFamily)annotation;

    assertEquals( "fetch", cf.family() );
  }
}
