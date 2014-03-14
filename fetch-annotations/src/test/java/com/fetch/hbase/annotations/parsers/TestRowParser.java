package com.fetch.hbase.annotations.parsers;

import com.fetch.hbase.annotations.Row;
import com.fetch.hbase.annotations.Table;
import com.fetch.hbase.annotations.parsers.RowParser;
import com.fetch.hbase.annotations.policy.Policy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestRowParser {
  @Table( name="Test" )
  private class TestKlass {
    @Row( policy=Policy.Code.REVERSE_TIMESTAMP )
    int id;
  }

  @Test
  public void test_that_the_row_parser_gets_the_value_correctly() {
    assertEquals( Policy.Code.REVERSE_TIMESTAMP, RowParser.getPolicyCode( TestKlass.class ) );
  }
}
