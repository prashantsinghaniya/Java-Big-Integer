import os
import subprocess
import sys

print("creating jar files")
os.system("jar cf arbitraryarithmetic/aarithmetic.jar arbitraryarithmetic/*.class")
print("compiling java files....")
os.system("javac -cp .:/arbitraryarithmetic/aarithmetic.jar MyInfArith.java")
print("running myinfarith")
lst = []
lst = input("Enter the arguments : \n").split(" ")
print(f"Entered arguments :{lst}\n")
print("Output :")
os.system(f"java -cp .:/arbitraryarithmetic/aarithmetic.jar MyInfArith {lst[0]} {lst[1]} {lst[2]} {lst[3]}")


# if(len(sys.argv) < 5):
#     print("Usage: python3 run.py <int/flot> <add/sub/mul/div> <operand1> <operand2>")
# else:
#     cmd = ["java", "MyInfArith"] + sys.argv[1:]
#     print("Running: java MyInfArith", *sys.argv[1:])
#     subprocess.run(cmd)

