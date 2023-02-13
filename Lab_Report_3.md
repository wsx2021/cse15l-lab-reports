# CSE15L Lab Reports
### Shixuan Wu
&nbsp;
&nbsp;
## Researching Commands

#### `less`: a command-line utility used to view the contents of a file or the output of another command one page at a time. It's similar to the more command, but has many more features and is generally considered a better tool for viewing large or complex files.
#### 1. `-E` or --quit-on-empty-file - Quits less immediately if the input file is empty or if there is nothing to display.
```
less -E non-fiction/OUP/Castro/chA.txt
```
![img](/images/lab3/less_e.png)


&nbsp;
#### 2. `-N` or --line-number - Displays line numbers in the output. I can see teh line number at the left side. 
```
less -N non-fiction/OUP/Castro/chA.txt
```
![img](/images/lab3/less_n.png)


&nbsp;
#### 3. +<number> - Starts less at the specified line number in the file. It directly guide me to the line 42 and after. 
```
less +42 -N  non-fiction/OUP/Castro/chA.txt
```
![img](/images/lab3/less_num.png)
&nbsp;
#### 4. `-M` or --long-prompt - Shows more detailed prompt with the file name and current line number. It shows the file name, line number, and what percentage the pointer at for the whole file. 
```
less -M  non-fiction/OUP/Castro/chA.txt
```
![img](/images/lab3/less_m.png)
&nbsp;
#### 5. `-S` or --chop-long-lines - Truncates lines that are too long to fit on the screen. The long lines only show the first part with >
```
less -S  non-fiction/OUP/Castro/chA.txt
```
![img](/images/lab3/less_s.png)
&nbsp;
#### 6. The `-w` option, or --hilite-search, is used to highlight searched words in the output of less. This display the contents of chA and highlight any searched words in the output. 
```
less -w -N  non-fiction/OUP/Castro/chA.txt
```
#### To search for a specific word, I press / and type in the word you want to search for. I type `/man` to search for man and it also highlights the word. 
![img](/images/lab3/less_w.png)
&nbsp;
#### 7. The `-X` or --no-init - Does not send the terminal initialization string, which is usually used to clear the screen before displaying the file. It does not clean the screen after I quit. I can still see the lines when I type the next command.
```
less -X  non-fiction/OUP/Castro/chA.txt
```
![img](/images/lab3/less_x.png)
&nbsp;
#### 8. With less, you can open multiple text files simultaneously and maintain your current position within each file. To do this, simply list the file names in succession when running the command. For example:
```
less -N  non-fiction/OUP/Castro/chA.txt travel_guides/berlitz1/WhereToItaly.txt
```
#### To switch to the second text file, I use `:n` to see the other text file. 
![img](/images/lab3/less_1.png)
![img](/images/lab3/less_2.png)
