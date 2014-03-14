fetchBase
=========

Utilities written to make HBase use easier.

This library hopes to fullfill the following functionality as well as syntax:

```java
@Table( name="logs" )
@ColumnFamily( family="fetchBase" )
public class Log {

  @Row( policy=RowPolicy.REVERSE_TIMESTAMP )
  public Long timestamp;
  
  public String address;
  public String errorString;
  public Integer errorCode;
  public String message;
    
  @ColumndFamily( family="fetchBase-unnormalized" )
  public String rawLog;
}
```

The above _Log_ class describes what a row is in HBase. To use the above the following is done.

```java
Table<Log> logsTable = new Table<Log>();

Log log = parseStringIntoLog( logString );

Result result = logsTable.add( log );//Defaults to the class annotated 
                                     //ColumnFamily "fetchBase" in this case.

if( result.successful() ) {
  System.out.println( "Successfully added log to HBase" );
} else {
  System.out.println( "Could not add log to HBase" );
  System.out.println( result.reason() );
}
```
