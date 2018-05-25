**************************************
*****	Conway's Game of Life	******
*****	Tahmina Tahsin		******
**************************************

Input file format:
==================
Input file name: gameOfLife.txt. 
The first line in the input file has two numbers: M N
M is the row and N is the column numbers of the grid. Following lines shows the states.
1 means LIVE and 0 means DEAD states.

You can run the program by running the following command:

> sh runProject.sh


Advanced Features:
==================

# Loop Through States:
int[][] findKthState(int k, int[][] initial) method:

The method takes an initial state and a number K. It returns the Kth state after the initial state.

# Support arbitrary sized grid:
change the input file to reflect any grid size

# Improve result display:
The output clearly shows which cell is live or dead at which generation.


Testing Project:
================

File: ConwayGameOfLifeTest.java

The test file tests the following scenario:

1. If the code can generate a valid 2D array from the input file and tests if that generated 2D array matches with the dummy Initial input that we created.

2. given an initial state if our code can generate the next state. I am testing the generated output against a manually created dummy Output to see if they are same.

3. given an initial state if our code can generate the kth state. I am testing the generated output against a manually created dummy kthState array to see if they are same.

You can run the test by running the following command:

> sh runTester.sh

**If you have problem running the Junit test file please copy the provided junit.jar file to /usr/share/java/ directory and then run the script.







		
