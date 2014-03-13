package com.fetch.hbase.annotations;

import com.fetch.hbase.annotations.exceptions.FetchTableException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestTable {
  @Table( name="test" )
  private class TestKlass {
  }

  @Test
  public void test_that_annotation_exists() {
    Class<TestKlass> obj = TestKlass.class;

    assertTrue( obj.isAnnotationPresent( Table.class ) );
  }

  @Test
  public void test_that_annotation_has_table_name() {
    Class<TestKlass> obj = TestKlass.class;
    Table table = (Table)obj.getAnnotation( Table.class );

    assertEquals( "test", table.name() );
  }
}
