#!/bin/bash

# Step 1: Generate parser files from Parser0.jj using JavaCC
echo "Generating parser files from Parser0.jj..."
java -cp "./javacc-javacc-7.0.10/target/javacc.jar" javacc Parser0.jj

# Check if parser generation was successful
if [ $? -ne 0 ]; then
    echo "JavaCC failed to generate parser files."
    exit 1
fi

# Step 2: Compile all .java files, including the generated parser files
echo "Compiling Java files..."
javac -classpath . *.java

# Check if compilation was successful
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Finish
echo "Compilation complete."
