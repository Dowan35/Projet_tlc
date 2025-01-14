@echo off
set SRC_DIR=src\main\java
set OUT_DIR=out
if not exist %OUT_DIR% (
    mkdir %OUT_DIR%
)
javac -d %OUT_DIR% %SRC_DIR%\**\*.java
echo Compilation terminée.
