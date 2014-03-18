package com.fetch.hbase.generators;

import java.util.Map;

public class TableGenerator<T extends ColumnGenerator> {
  public class TableInformationContainer {
    Map<Class<?>, T> tableColumns;
  }
}
