@echo off

set JAVA_HOME=C:\Program Files\Java\jre1.8.0_181
set DERBY_HOME=C:\Program Files\Java\jre1.8.0_181\db-derby-10.14.2.0-lib
set DERBY_JARS=%DERBY_HOME%\lib\derby.jar;%DERBY_HOME%\lib\derbytools.jar;%DERBY_HOME%\lib\derbynet.jar;%DERBY_HOME%\lib\derbyclient.jar

java -Dderby.system.home=C:\DerbyDbs -cp "%DERBY_JARS%" -Dij.protocol=jdbc:derby org.apache.derby.tools.ij