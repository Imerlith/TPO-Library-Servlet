@echo off
set JAVA_HOME=C:\Program Files\Java\jre1.8.0_181
set DERBY_HOME=C:\Program Files\Java\jre1.8.0_181\db-derby-10.14.2.0-lib
set DERBY_JARS=%DERBY_HOME%/lib/derby.jar;%DERBY_HOME%/lib/derbynet.jar;%DERBY_HOME%/lib/derbyclient.jar;%DERBY_HOME%/lib/derbytools.jar
set DERBY_SYSTEM_HOME=C:\DerbyDbs

"%JAVA_HOME%\bin\java" -Dderby.system.home=%DERBY_SYSTEM_HOME% -cp "%DERBY_JARS%;%CLASSPATH%" -Dij.protocol=jdbc:derby: org.apache.derby.tools.ij createdb.sql