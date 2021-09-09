#                            Welcome to the repository
##                          Employee salary calculator

###-------------- Introduction ----------------
"Employee salary calculator" is a project created using the Java language and executed in the NetBeand IDE 12.4 application.
The project calculates how much the salary of the employees is based on the information found in a .txt file such as their name, days and time worked.

### -------------- Code structure --------------
The functionality of this project consists of two files, the file EmployeesHorarios.txt found in the main section when the folder CalculatorEmployee is opened, and second, the code in the Main.java class.

The code has the following structure, in the header are the necessary libraries, within the Main class in the code block it is started by initializing a null value file, followed by try-catch to handle code fragments that are prone to failure . While loop to go through each line of the file, handling of spacing corrections and conversions from strings to lists. For cycle to cycle through a list of the days-hours worked by the employee. Separation and assignment of string variables between days and hours, conversion of input and output time strings to integers for calculations.
In this part of the code (line 82) if & else if structures are used to assign selection parameters based on the day of the week, within these structures there are other if & else if conditionals that help in the value to pay in a range of established hours, depending on the values that enter these conditionals, 3 operations will be performed, a subtraction to calculate the number of hours worked, a multiplication with the value per hour and the number of hours, and an assignment of the result to be paid to a located accountant. outside of the for loop.
At the end of having traveled EACH LINE of the file, a message is printed on the screen along with the values of the name used and the total to be paid.

### --------------  Approach and methodology -----------------
To handle large amounts of data in a file, it is necessary to look for parameters that allow us to filter this information, for example, when wanting to obtain the employee's name from each line, choose to convert the line into an arrangement divided by the equal sign "=" Since for me this was a separator, as a result I would have an arrangement with two objects, the name of the employee and the second his working hours, from this second object (days and hours worked) which was a string of characters I converted it into a list separate by commas ",", this to be able to have a list of each day worked separately along with their schedules respectively.
He went through each object on this list of days that the employee worked dividing the initial of the day by the hours and converting the hours into positive integers to be able to do the calculations and obtain the value to pay.

I used conditionals to filter the information since on certain days of the week the value of the hourly payment is the same in certain time ranges, finally, on each occasion that the conditional parameters are met, calculations will be made to assign the value to pay for the day worked to an accountant who will take the total amount to pay.


**Instructions:**

   - Download Apache NetBeans and Java version 16.0.2.
   
   - Download the project from the repository.
   
   - Open project in NetBeans and run it.
   
#### Download Apache NetBeans and Java version 16.0.2

To download netbeans you can follow the following link of the official documentation and download the most optimal version for your device and execute the installation instructions. [Apache NetBeans](https://netbeans.apache.org/download/nb124/nb124.html "Apache NetBeans")

The Java version that is handled in this project is 16.0.2, in the following link you will find. [Java ](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html "Java ")

#### Download the project from the repository.

- Download a compressed file (.zip) of this project and save it on your computer.
- Unzip the project in the folder where you saved it.

#### Open project in NetBeans and run it.
To import a project into NetBeans, you must make sure that there is no project with the same name in working directory. The project folder will be unzipped or copied in a directory (it can be in the NetBeans working directory) and the following steps are carried out.

Select **File** --> **Open Project** and select the path and project to load and select **Open Project**. The project is loaded into the work area.

Inside the project you will find four packages
- Source Packages
- Test Packages
- Libraries
- Test Libraries

Inside **Source Packages** you will find the **calculadoraempleado** package and within this package the main class **Main.java**, to run the program right click on the **Main.java** file and in the options menu click on **Run File**.
