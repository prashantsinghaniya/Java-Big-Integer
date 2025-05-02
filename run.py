import os

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
