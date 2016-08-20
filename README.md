# French Test using a GUI in Java (swing)

I began this GUI by following on from my frenchTranslations.c program (found in https://github.com/scottbanyard/french-programs-C).
I wanted to be able to represent a test system with a GUI, so I decided to recap swing in Java.

Simple UI shown below :

![alt text](https://github.com/scottbanyard/french-gui-test-java/blob/master/images/simpleUI.png "a test of month knowledge")

### Installation

- open up a command line / terminal and **cd** into a directory
- type in `git clone https://github.com/scottbanyard/french-gui-test-java`
- ensure you have java installed (type in `java -v`), download if you haven't
- type in `javac Main.java MonthsTest.java NumbersTest.java ColoursTest.java` to create the program
- type in `java Main` to run the program

### Current Progress:

- full test questions in place for months and colours
- only asks questions on certain numbers
- score system - tells you how many you got right at the end
- asks 5 random questions
- quit button

### Improvements:

- improve design - make it look more colourful
- work out a system to ask questions on all numbers (index possibly - done in C program)
- feedback on questions you got wrong (show right answer - done in C program)
