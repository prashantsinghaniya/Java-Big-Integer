import os
import subprocess
import sys

print("compiling java files....")
os.system("javac -d . arbitraryarithmetic/*.java MyInfArith.java")

print("creating jar files")
os.system("jar cf arithmetic.jar arbitraryarithmetic/*.class")

if(len(sys.argv) < 5):
    print("Usage: python3 run.py <int/flot> <add/sub/mul/div> <operand1> <operand2>")
else:
    cmd = ["java", "MyInfArith"] + sys.argv[1:]
    print("Running: java MyInfArith", *sys.argv[1:])
    subprocess.run(cmd)

