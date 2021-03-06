package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.Table;
import com.fetch.hbase.annotations.ColumnFamily;
import com.fetch.hbase.annotations.exceptions.FetchColumnFamilyException;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestColumnFamilyParser {
  @Table( name="test" )
  private class TestKlass {
    @ColumnFamily( family="test" )
    int test;

    @ColumnFamily( family="test2" )
    int test2;
  }

  @Table( name="test" )
  @ColumnFamily( family="test" )
  private class TestKlass2 {
  }

  @Test
  public void test_that_the_class_annotated_has_correct_family_name() throws FetchColumnFamilyException {
    String familyNames = ColumnFamilyParser.getColumnFamilies( TestKlass2.class );

    assertEquals( "test", familyNames );
  }
}
