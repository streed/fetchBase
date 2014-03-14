package com.fetch.hbase.annotations;

import com.fetch.hbase.annotations.policy.Policy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestRow {
  private class TestKlass {
    @Row( policy=Policy.Code.REVERSE_TIMESTAMP )
    int id;
  }

  @Test
  public void test_that_the_policy_value_is_correct() {
    Field [] fields = TestKlass.class.getDeclaredFields();

    Annotation annotation = fields[0].getAnnotation( Row.class );

    Row row = (Row)annotation;

    assertEquals( Policy.Code.REVERSE_TIMESTAMP, row.policy() );
  }
}
