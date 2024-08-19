
# Program of Programs
### This is a program made to go through my collections of projects and lessons from my programming classes. 

This is my Program of Programs. I am setting up a way to go through my projects and some lessons that would allow the user to interact and understand the programs, algorithms and lessons. 

A few things you will need to do to get this to run. You will need to have mySQL installed and your Username and Password for the databases. Then you can go into the "DatabaseConnection.java" class and insert them there. Databases will be created in the first run of each program, so far only Dealership and GPASorter programs utilize mySQL as of this iteration. 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

First project is an program that a dealership could use to work with inventory. It was my first project in my programming classes. These are "simple" and "incomplete". The longer I work with them the more I find myself stating, "I could do this or that", however, I should do this from the start so these are as I was instructed to accomplish. 

>There are 3 classes for this program. 
>-Dealership (main), 
>-Automobile (main object), 
>-AutoInventory (data manipulation).

>This is the instruction I was given:
>Your Portfolio Project will consist of three components:

    Program corrections: Make the appropriate corrections to all the programming assignments submitted as Critical Thinking assignments from Modules 1-6. You will need to submit the programs along with the carefully outlined corrections needed in order for the programs to run correctly.
    Lessons learned reflection: Create a 2-3-page summary that outlines the lessons learned in this Programming I course.
    Final program: Create a final program that meets the requirements outlined below.
    Final Program Requirements
    Create an automobile class that will be used by a dealership as a vehicle inventory program. The following attributes should be present in your automobile class:

        private string make
        private string model
        private string color
        private int year
        private int mileage
        Your program should have appropriate methods such as:

        default constructor
        parameterized constructor
        add a new vehicle  method
        list vehicle information (return string array)
        remove a vehicle method
        update vehicle attributes method
        All methods should include try..catch constructs. Except as noted all methods should return a success or failure message (failure message defined in "catch").

    Create an additional class to call your automobile class (e.g., Main or AutomobileInventory). Include a try..catch construct and print it to the console.
    Call automobile class with parameterized constructor (e.g., "make, model, color, year, mileage").
    Then call the method to list the values. Loop through the array and print to the screen.
    Call the remove vehicle method to clear the variables.
    Print the return value.
    Add a new vehicle.
    Print the return value.
    Call the list method and print the new vehicle information to the screen.
    Update the vehicle.
    Print the return value.
    Call the listing method and print the information to the screen.
    Display a message asking if the user wants to print the information to a file (Y or N).
    Use a scanner to capture the response. If "Y", print the file to a predefined location (e.g., C:\Temp\Autos.txt). Note: you may want to create a method to print the information in the main class.
    If "N", indicate that a file will not be printed.
     
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

