package com.fetch.hbase.utils.helpers;


import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class PutHelper {
  private final Put put;
  private final String family;
  
  public PutHelper( final String id, final String family ) {
    this.family = family;
    put = new Put( Bytes.toBytes( id ) );
  }

  public PutHelper add( final String col, final String val ) {
    put.add( Bytes.toBytes( family ), Bytes.toBytes( col ), Bytes.toBytes( val ) );
    return this;
  }

  public Put get() {
    return put;
  }
}
