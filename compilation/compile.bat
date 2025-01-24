@echo off
REM Set variables
set ANTLR_JAR=.\src\lib\antlr-3.5.3-complete-no-st3.jar
set GRAMMAR_FILE=grammaire\grammaire.g4
set OUTPUT_DIR=output
set SRC_DIR=src
set BUILD_DIR=build
set EXECUTABLE=my_program

REM Paths to ANTLR runtime (adjust these for your setup)
set ANTLR_INCLUDE=.\src\lib\antlr-3.5.3-complete-no-st3.jar
set ANTLR_LIB=.\src\lib\
set ANTLR_RUNTIME_LIB=antlr4-runtime.lib

REM Create directories if they don't exist
if not exist "%OUTPUT_DIR%" mkdir "%OUTPUT_DIR%"
if not exist "%BUILD_DIR%" mkdir "%BUILD_DIR%"

REM Step 1: Generate C++ code from ANTLR grammar
echo Generating C++ code from ANTLR grammar...
java -jar "%ANTLR_JAR%" -Dlanguage=Cpp -visitor -listener -o "%OUTPUT_DIR%" "%GRAMMAR_FILE%"
if errorlevel 1 (
    echo Error: Failed to generate C++ code from ANTLR grammar.
    exit /b 1
)

REM Step 2: Compile the C++ code
echo Compiling C++ code...
cl /std:c++17 /I"%ANTLR_INCLUDE%" "%OUTPUT_DIR%\*.cpp" "%SRC_DIR%\*.cpp" /link /LIBPATH:"%ANTLR_LIB%" "%ANTLR_RUNTIME_LIB%" /OUT:"%BUILD_DIR%\%EXECUTABLE%.exe"
if errorlevel 1 (
    echo Error: Compilation failed.
    exit /b 1
)

REM Step 3: Notify success
echo Build successful. Executable created at: "%BUILD_DIR%\%EXECUTABLE%.exe"
