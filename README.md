
# DummyLang-Interpreter in Java

This project is a playful twist on Monkey-Lang, inspired by the book *Writing an Interpreter in Go* by Thorsten Ball. We’ve decided to bring this language to life with a Java backend, using Jasmin for grammar and parsing. Get ready to monkey around with DummyLang!

## Features
- **Variable and Constant Declarations**: Declare variables (`var a;`, `var a := 10;`) and constants (`const b := 20;`) to store values.
- **Pointer Operations**: Access memory locations and manipulate data with pointers (`var #p := 1.1;!p;`, `var #a :=1; var #p := !a;`).
- **Control Flow**: Use loops (`while`, `for`) and functions to structure your code (`fn f(n,j){...}`).
- **Recursive Functions**: Implement recursive functions, like calculating Fibonacci numbers.

## Getting Started

### Prerequisites
To build and run DummyLang, ensure you have the following installed:
- **Java Development Kit (JDK) 1.8 or higher**
- **Maven**

### Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/dummy-lang.git
   ```
2. Navigate to the project directory:
   ```bash
   cd dummy-lang
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Examples
Check out the tests in `DummyLangTests` for examples on how DummyLang handles:


## Future
- More tests for edge cases
- Enhanced error handling
- Developing a compiler for DummyLang
- Proper documentation and examples
