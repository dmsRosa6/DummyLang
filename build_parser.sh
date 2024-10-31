#!/bin/bash

# Define the package and paths
PACKAGE_NAME="com.dummylang.parser"
PACKAGE_LINE="package ${PACKAGE_NAME};"
GENERATED_DIR="target/generated-sources/javacc"
TARGET_DIR="src/main/java/${PACKAGE_NAME//./\/}"

# Step 1: Run Maven generate-sources
echo "Running Maven generate-sources..."
mvn generate-sources -e

# Check if Maven command succeeded
if [[ $? -ne 0 ]]; then
  echo "Maven generate-sources failed."
  exit 1
fi

# Step 2: Modify generated files to include the package statement
echo "Adding package statement to generated files..."

# Create the target directory if it doesn't exist
mkdir -p "$TARGET_DIR"

# Process each .java file in the generated directory
for file in "$GENERATED_DIR"/*.java; do
  # Check if the package line is already present
  if ! grep -q "^${PACKAGE_LINE}" "$file"; then
    # Insert package line at the top of the file
    { echo "$PACKAGE_LINE"; cat "$file"; } > temp_file && mv temp_file "$file"
    echo "Added package statement to $file"
  else
    echo "Package statement already exists in $file"
  fi

  # Step 3: Move modified files to the target directory
  mv "$file" "$TARGET_DIR/"
  echo "Moved $file to $TARGET_DIR"
done

# Clean target
# mvn clean

echo "All files processed and moved to $TARGET_DIR."
