# Object oriented Production Project (OOP)
One paragraph of project description goes here.<br />

This is my object oriented production project. It is a project that is intended to be used in a big production company as a way to keep track of their big list of products, and their history of production. It has a database for all the products of the company and another database for the actual production history. It also has a tab where the employee on shift has to sign up. This program was made by myself, Ronald Quiroz whith guidence of my college professor Scott Vanselow. I made it over the 2020 Fall semester as a current junior software engineer student of Florida Gulf Coast University (FGCU). I made this program for professor Vanselow's class of object oriented programming(COP 3003) as the biggest assignment of the semester. I've gone thoroughly over the instructions and add some little pieces of code to make the program more user friendly. Between my human user factor changes are: 
1. Feedback messages in the Product Line tab(Tab1). 
2. Clearing the textFields once a product is successfully added, so he user can keep adding more products easily in the Product Line tab.
3. Selecting automatically the most recent product added in the Product Line tab.
4. To avoid errors, the "Record Production" button is unavailable until a product is selected from the listView in the Produce tab (Tab2).
5. Feedback message in Produce Tab for succesfully produced products.
6. A "Refresh" button in the Production Log tab(Tab 3), so if changes are not registered automatically the user still can refresh and see them.
7. Feedback message if there are no changes to report in the Production Log tab after clicking refresh.
8. Help button with instructions for creating a valid name and password in the Employee tab(Tab 4).
9. Feedback messages in the Employee tab(Tab4).
10. A pop-up window to display the Employee information once the name and password are filed and the sign in button is clicked.
11. clearing the textFields once the pop-up window is closed, so another the employee can try again easily.


## Demonstration

Here is an animated gif of the program running, show casing some of its main features. <br />
![Demonstration GIF](resources/Demonstration.gif)  <br />
Here is a link to a longer video showing off some of the changes made taking into consideration human user factor:  <br />
https://youtu.be/RvRmaUMSBEU

## Documentation

Create a docs folder in your project. If using Java, generate JavaDoc in your IDE. If using C++, use Doxygen. Change repository settings (using Settings at top of page) to use GitHub Pages with your docs folder. Add a link to the javadoc/doxygen index.html file with this markdown: \[Text to appear]\(URL) <br />
The URL will be rjquiroz.github.io/OOP/JavaDoc/index.html <br /> 
Do not include the docs folder name in your URL. <br />
Sample: \[JavaDoc]\(https://pv-cop.github.io/PV-README-TEMPLATE/javadoc/index.html) <br /> <br />
[JavaDoc](https://github.com/rjquiroz/OOP/blob/master/JavaDoc/index.html)

## Diagrams

Class Diagram: <br />
![Class Diagram](resources/ClassesDiagram.png) <br />
Database Diagram: <br />
![Database Diagram](resources/DatabaseDiagram.png) <br />

## Getting Started

In order to get the program running in your computer in IntelliJ you need to follow the next steps:
1. Copy the link or URL for this repository.
2. Open IntelliJ.
3. Close any projects that you might have open at the time.
4. Click on "Get from Version Control".
5. Make sure that on the left side you have selected "Repository URL".
6. Paste the URL of the repository where says "URL" and click "Clone".
7. After it is cloned, you go to OOP>src>main>java and right click the "Main" class and click on "Run 'Main.main()'".
8. Finally, if the program does not run, go to "Run" on the menu bar on top. Then, click on "Edit Configurations" and paste this into the "VM Options" text box:

                      --module-path C:\Users\ronal\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml 
                      
 (but include the directory where is located your javafx.lib. instead of mines.)
 9. Then right click Main and run it again, and it should run smoothly.
## Built With
* JavaFX project using Java 11 and Gradle.
* IDE: IntelliJ IDEA Ultimate version 2020.2 
* H2 Database Engine version 1.4.200 (2019-10-14)
* SceneBuilder for Java 11 version 11.0.0  

## Contributing
Because of the timespan there were many things that I have to left it out. Thus, the program still has much room for improvement such as: we can make that the database reads the username and password from a text file or maybe we can make it a login window where we need to enter the correct username and password to access to the database. Also, the Employee tab functions by itself, but it really does not contribute to the program as whole. It can be added that once the employee signs in, then in the production log tab is registered which employee added or produced that specific product. I am just sharing some ideas that I might try to work on for this program after. <br />

## Author

* Ronald Quiroz.

## License

[License](LICENSE) <br />


## Acknowledgments

* The course website, put together by my professor, was of massive help from the instructions all the way to the extra resources.
* I appreciate the help of my professor Scott Vanselow for help me out when I was stuck.

## History

This is the completed version after a semester of putting together small parts of the program at a time.

## Key Programming Concepts Utilized
* Object Oriented Programming: programming base on objects created with a particular behavior. <br />
* Enum: A group of constants variables. <br />
* Interfaces: A contract class with abstract methods (without body). Another class must implement this interface for it to access the methods and give them a body. <br />
* Abstract Class: A class that cannot be instantiated, but it can be referenced. So, we can talk about this class, but we cannot create objects of this class. <br />
* Overring methods: A method in a subclass with the same name, parameters and return type as a method in its super class. <br />
* Overloading methods: Two methods with the same name, but different parameters.
