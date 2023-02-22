# CSE15L Lab Report 4
### Shixuan Wu
&nbsp;
&nbsp;
## Steps Instructions

### 1. Setup Delete any existing forks of the repository you have on your account

#### I login to my github and go to setting, than delete my repo of lab7
&nbsp;

### 2. Setup Fork the repository
#### I got to the lab7 repo. Then, I click the fork button and go through the instruction to set up my own repo. 
&nbsp;
### 3. The real deal Start the timer!
&nbsp;
### 4. Log into ieng6
#### I type 
```
ssh cs15lwi23axe@ieng6.ucsd.edu
```
&nbsp;
### 5. Clone your fork of the repository from your Github account
#### I just type
```
git clone git@github.com:ucsd-cse15l-w23/lab7.git
```
<enter>

### 6. Run the tests, demonstrating that they fail
#### I use reverse search Ctrl+R and searh *junit* to find the line I typed before and when I saw 
```
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
```
#### and then <enter>. I do the same to find the line 
```
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ListExmaples
```

####  and then <enter>
&nbsp;

### 7. Edit the code file to fix the failing test
#### I type nano L and then tab it will autofill the filename for me. I can just add java to the end of it. 
#### After nano, I just do Ctrl+shift+- and then enter 43 to go to the 43 line. I can directly chanhe theh index1 to index2.   
&nbsp;
### 8. Run the tests, demonstrating that they now succeed
#### I do <up><up><up><enter> and <up><up><up><enter> to rerun the junit commands. This command was 3 up in myhistory, therefore I use <up> and ran it in the same way. It will show me test succeeded. 
&nbsp;
### 9. Commit and push the resulting change to your Github account (you can pick any commit message!)
####  I will do 
```
git add .
```
<enter>

#### and 
```
git commit -m "update"
```
<enter>

#### and push the chanegs
```
git push
```
<enter>

