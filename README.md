
# Program of Programs

### This is my Program of Programs. I am setting up a way to go through my projects and some lessons that would allow the user to interact and understand the programs, algorithms and lessons. 

# Setup

![](https://github.com/DarthStory/ProgramOfPrograms/blob/main/Overview%20Flowchart.jpg)

A few things you will need to do to get this to run. You will need to have mySQL installed. The Dealership Inventory Program will ask for your credentials to create the necessary database and tables. Only the Dealership Inventory program utilizes mySQL for data storage. I was going to put it into the Student Sorter program but felt non-persistant data for that program was fine. The Bag Manipulation is also non-persistant, and the Sorting Algorithms program is more of an educational program. 

#

## Section 1. First project 
This is a program that a Dealership could use to work with inventory. It was my first project in my programming classes. These are "simple" and "incomplete". The longer I work with them the more I find myself stating, "I could do this or that", however, this is just to demonstrate my abilities, not be a full fledged program. I could not help but want to keep the information in a database as it felt that with at least one of my programs, I needed persistant data. All of our programs we learned nothing existed past the closure of the program. I added certain things to this Dealership Project to demonstrate that. I never actually learned how to connect to a database, how to implement a database, how to store passwords, or how to encrypt passwords. Everything that works with the Database was of my own want to do so.   

## This is the instruction I was given:

>There are 3 classes for this program.
> - Dealership (main)
> - Automobile (main object)
> - AutoInventory (data manipulation)

### Final program: Create a final program that meets the requirements outlined below.

>Create an automobile class that will be used by a dealership as a vehicle inventory program. The following attributes should be present in your automobile class:

- private string make
- private string model
- private string color
- private int year
- private int mileage
>#### Your program should have appropriate methods such as:

- default constructor
- parameterized constructor
- add a new vehicle  method
- list vehicle information (return string array)
- remove a vehicle method
- update vehicle attributes method

>All methods should include try..catch constructs. Except as noted all methods should return a success or failure message (failure message defined in "catch").

1. Create an additional class to call your automobile class (e.g., Main or AutomobileInventory). Include a try..catch construct and print it to the console.
2. Call automobile class with parameterized constructor (e.g., "make, model, color, year, mileage").
Then call the method to list the values. Loop through the array and print to the screen.
3. Call the remove vehicle method to clear the variables.
Print the return value. 
4. Add a new vehicle. Print the return value. Call the list method and print the new vehicle information to the screen.

5. Update the vehicle. Print the return value. Call the listing method and print the information to the screen.

6. Display a message asking if the user wants to print the information to a file (Y or N). Use a scanner to capture the response. If "Y", print the file to a predefined location (e.g., C:\Temp\Autos.txt).

Note: you may want to create a method to print the information in the main class.
If "N", indicate that a file will not be printed.
## Section 2. List of Students. Sort and Print

This project we were given the task to create a student object and manipulate it. Data should be user generated. 

## This is what we were given to do:

>Write a Java program that incorporates a loop that prompts the user for student data. Student data are private fields in a student class including:

- String name
- String address
- double GPA
- Each student object is stored in a linked list.

>After the user completes the data entry, output the contents of the linked list in ascending sorted order by name to a regular text file that can be opened and viewed using a simple plain-text editor such as notepad.

>Validate numeric data for Grade Point Average (GPA).

## Section 3. Bag Manipulation

This weekly project we were given was to manipulate the items in a bag. I chose to have user input as I do all of my projects. This was sort of a merger of 2 different week's projects. I saw no reason why I could not incorporate the previous weeks work and make one program to do more than a few things. Add, Remove, Contains, Clear, Count, merge, size, create a Set, and Print. There are 2 bags but the user only initially enters 10 "things" into the Bag. This can be any of the variables. 

## Section 4. Sorting Algorithms Overview

In this program I went through 5 different sorting methods and explained how each one worked. I was able to use the user in put in the examples to show when and where changes occurred. I attempted to make it as educational since most of a sorting algorithm is behind the scenes and not something the user manipulates. 

