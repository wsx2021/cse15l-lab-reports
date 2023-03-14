# CSE15L Lab Report 5
### Shixuan Wu
&nbsp;
&nbsp;
## Lab 6 Activities


### I finish the grading script and this report contains screenshots that demonstrate it working on several files.
&nbsp;

### First, I set up the PATH variables for both Mac and windows computers. 
### Then, I clone the student submission file and check for teh file needed. If it is found, we proceed. If not, I will print message and exit with code 1. Next, I try to compile the test and check for any complie error. If nothing goes wrong, I will output the jUnit test output to the output file. Uisng the output text, I will be able to tell whether the student is not pass, partial pass or full pass.  
### Here is my bash script: 
``` bash
CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'
WPATH=".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar"

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'
cp *.java ./student-submission
cd student-submission
if [[ -f ListExamples.java ]]
then  
    echo "ListExamples.java found"
else 
    echo "Need file ListExamples"
    echo "Your Grade: Not PASS"
    exit 1
fi

javac -cp $WPATH *.java
if [ $? != 0 ]
then
  echo "Compling Failure!!!"
  echo "Your Grade: Not PASS"
  exit 1
fi
echo "Complied Successfully"
java -cp $WPATH org.junit.runner.JUnitCore TestListExamples > output.txt
# cat output.txt
# cp output.txt ../
grep "OK" output.txt > grade.txt

if [[ `wc -l grade.txt` == "0 grade.txt" ]]
then 
    grep "Failures: 1" output.txt > fail.txt
    if [[ `wc -l fail.txt` == "1 fail.txt" ]]
    then
        echo "Your Grade: Partial PASS"
        exit 2
    fi
    echo "Your Grade: NOT PASS"
    exit 2
fi
echo "Your Grade: PASS!"
```
&nbsp;
&nbsp;
#### Here is screenshot When I test it on `list-methods-lab3`
![plot](/images/bash_1.png)
#### It said partial pass, since one of test is failed.
&nbsp;
&nbsp;
#### Here is screenshot When I test it on `list-methods-corrected`
![plot](/images/bash_correct.png)
#### It said full pass, since all of test is passed.
&nbsp;
&nbsp;
#### Here is screenshot When I test it on `list-methods-compile-error`
![plot](/images/bash_error.png)
#### It said Not pass, and it also points out compling error.
&nbsp;
&nbsp;
#### Here is screenshot When I test it on `list-methods-nested`
![plot](/images/bash_file.png)
#### It said Not pass, and need the file ListExamples.  
&nbsp;
&nbsp;
#### Here is screenshot When I test it on `list-methods-subtle`
![plot](/images/bash_subtle.png)
#### It said partial pass, since one of test is failed.
&nbsp;
&nbsp;
&nbsp;
