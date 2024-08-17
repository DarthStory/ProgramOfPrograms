This is my Program of Programs. I am setting up a way to go through my projects and some lessons that would allow the user to interact and understand the programs, algorithms and lessons. 

A few things you will need to do to get this to run. You will need to have mySQL installed and your Username and Password for the databases. Then you can go into the "DatabaseConnection.java" class and insert them there. Databases will be created in the first run of each program, so far only Dealership and GPASorter programs utilize mySQL as of this iteration. 

Sorting Algorithms Overview
    1. tell user what we are going to do
    2. request 10 integers under 100
    3. store those integers in an array
    4. Ask the user to pick an algorithm to go over
    5. *Using the numbers they gave in the array, go through the steps in sorting the array.
        a. I will need to explain the array sort method. 
        b. I will need to keep the orgiginal array of integers they created to reference, then after sorted, I can identify what numbers are the smallest to largest and what number they replace.
        c. use this outline in order to progress the "lesson"
            1. Initialize: Determine the size of the list.
            2. Outer Loop: Iterate over the list from the first element to the second-to-last element.
            3. Assume Minimum: Assume the current element (at index i) is the smallest, and store its index as minIndex.
            4. Inner Loop: Iterate over the remaining unsorted portion of the list (from index i + 1 to the last element).
            5. Find Minimum: Compare each element in the unsorted portion to the current minimum. If a smaller element is found, update minIndex 
                to the index of this smaller element.
            6. Swap: Swap the element at the current index (i) with the element at minIndex.
            7. Repeat: Repeat steps 3-6 for each element in the list until the entire list is sorted.
            8. Completion: The list is now sorted.
    6. Ask user if they want to go over another array
    7. repeat *
    8. if they say no, exit to main program. 

