SETLOCAL

SET WORKING_DIR=%~dp0
cd %WORKING_DIR%

del /q ..\jar\*.*
mvn -U clean -Ddeploy.phase=local install dependency:copy-dependencies -DoutputDirectory=..\jar

ENDLOCAL