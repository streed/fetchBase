package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.Table;
import com.fetch.hbase.annotations.exceptions.FetchTableException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestTableParser {
  @Table( name="test" )
  private class TestKlass {
  }

  private class ErrorKlass {
  }

  @Test
  public void test_that_the_parser_gets_the_table_name_correctly() throws FetchTableException {
    assertEquals( "test", TableParser.getTable( TestKlass.class ) );
  }

  @Test( expected=FetchTableException.class )
  public void test_that_the_parser_throws_the_exception_when_not_annotated() throws FetchTableException {
    TableParser.getTable( ErrorKlass.class );
  }
}
