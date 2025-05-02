# Arbitrary Precision Arithmetic Library

This project is part of the Software Development Fundamentals (SDF) course (CS1023, Jan-May 2025). It implements an arbitrary-precision arithmetic library in Java, supporting operations on integers (`AInteger`) and floating-point numbers (`AFloat`) with unlimited size and up to 30 digits of precision for floating-point division. The library includes a command-line interface via `MyInfArith`.

## Project Structure

```plaintext
SDF PROJECT/
│
├── arbitraryarithmetic/
│   ├── AInteger.java           # Implementation for integers
│   ├── AFloat.java             # Implementation for floats
│   └── aarithmetic.jar         # Compiled JAR file containing arithmetic classes
|
├── rawLeTeX/
|   ├── report.pdf              # pdf of report
|   ├── report.tex              # report of project
|
├── MyInfArith.java             # Main driver program
├── build.xml                   # Apache Ant build script
├── Dockerfile                  # Docker instructions for containerizing the project
├── run.py               # Python helper script for testing/running code
└── README.md                   # Project documentation (this file)
```

## Prerequisites

- **Java**: JDK 17 or later (e.g., Eclipse Temurin JDK 17).
- **Ant**: For building the project.
- **Docker**: For running the containerized version (optional).
- **LaTeX**: For compiling the report (e.g., MiKTeX, TeX Live).
- **Python**: For running `run.py` (optional).

## How to use 

# Arbitrary Precision Arithmetic Library
A Java library for arbitrary-precision arithmetic on integers and floating-point numb
## Compilation
Run: ‘ant compile‘
Package: ‘ant jar‘
## Command-Line Usage
Execute: ‘java -cp aarithmetic.jar MyInfArith <int/float> <add/sub/mul/div> <op1> <op
Example: ‘java -cp aarithmetic.jar MyInfArith int add 123 456‘
Output: ‘579‘
## Library Usage
Include ‘aarithmetic.jar‘ in your project to use ‘AInteger‘ and ‘AFloat‘ classes.
Example:
- Import ‘arbitraryarithmetic.AInteger‘
- Create instances: ‘AInteger a = AInteger.parse("123");‘
- Perform operations: ‘AInteger sum = AInteger.addition(a, AInteger.parse("456"));‘
- Output: ‘579‘
## Requirements
- Java 11 or higher
- Ant for building


## Project Features

- Supports arbitrary-precision arithmetic for integers (`AInteger`) and floating-point numbers (`AFloat`).
- Operations: addition, subtraction, multiplication, division.
- Floating-point division precision up to 30 digits.
- Command-line interface via `MyInfArith`.
- Containerized using Docker for portability.