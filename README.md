# Add Review Use Case by KenanBogopa(Elang Bogopa on Quercus)

![CAExplanation](images/CAExplanation.png)

 ## 1.Packaging

    I devided my Use case into 5 packages.
    
    Frameworks & Drivers (Blue)
    cli
    courseDataAccess
    
    **********************************************************************
    
    Interface Adapters (Green)
    LeaveReviewInterfaceAdapters

    **********************************************************************

    Application Business Rules (Red)
    LeaveReviewUseCase

    **********************************************************************

    Enterprise Business Rules (Yellow)
    entities
    


## 2.Javadoc and Testing
    
    Packages that were documented using JavaDoc:

    courseDataAccess
    LeaveReviewInterfaceAdapters
    LeaveReviewUseCase
    entities
    
    **********************************************************************
    Documenting cli was omittied, as it only uses Presenter and Controller
    classes from interfaceAdapters package.

    **********************************************************************
    Tests are provided for every class and method except for the cli
    package, as testing it would be unconvinient, because the only function
    of this package is to display output and accept input from the user.

    **********************************************************************
    Unfortunately, I didn't figure out how to generate the test report, but
    all tests are runnable, and can be run by running NameOfClassTest.java.
    



## 3. CLI

![CLIExplanation](images/CLIExplanation.jpg)

    The following diagram explains how the CLI works.

    **********************************************************************

    I would also like to note that I made CLI the way it is open for 
    extention. For instance, and infinte amount of other options can
    be added to MainMenu, by just adding one more if statement and
    making a call of other interface that will lead user further.

## 4. Update 11/28/22

I have created my UseCase classes, InterfaceAdapters and added required methods to my entities of interest.
I am still having trouble running my code and adding tests. I am trying to figure it all out.


## 5. Update 12/04/22

I added tests to my code  and this revealed that my interactor was not working as it should because it was not correctly updating the database.
I added even more tests to test if the review class and course class were being updated correctly whenever a review was created and added to a course.
I then added docstrings to the Review Class, Course Class, Controller, Presenter and UseCase classes such as Interactor and Boundaries.
I then created 3 request models namely Comment, Course and Rating request models. This was done to make the code clean and SOLID by reducing the controllers dependency on User Input.
I then integrated the request models with the controller and Interactor.
I then noticed that some of my entities' instance variables were not private so I made them private so that they are more protected.

## 6. Update 12/05/22

I began creating the individual CLI for my specific UseCase.
I created the custom exception called InvalidCommentLength Exception which was raised when the comment length did not abide by the restrictions.
This changed made the CLI accurately tell the user what was wrong with their input if there was something wrong with their input.
I noticed at night time that certain invalid input crashed the program while it was running so I spent the whole night trying to figure it out.

## 7. Update 12/06/22

I found a way to handle these invalid inputs! These user inputs that crashed the code where called InputMismatcException and they crashed my code even if I added a catch clause to them.
So I thought of changing int scanners to String scanners and then checking if this input is valid from there. This meant that no invalid input would crash the code but it also meant that I had to change the type paramenter of rating in my Interactor from int to String.
My program now works perfectly individually with a CLI and I decided to merge it with (22-view-courselike-review). I did this because (22-viewcourselike-review) already had other UseCases merged to it so it mimiced main.

## 8. Update 12/07/22

Inorder to merge with (22-viewcourselike-review) I had to refactor my files so that it is clear that they belong to my usecase.
I merged the files properly and then whole program functioned well.
I did noticed however that the CLI of the entire program was very fragile as other UseCases would crash if certain invalid input was entered.(InputMismatch to be exact).
I then decided to fix this by changing all int scanners in everyone elses CLI to string scanners so that InputMismatchExceptions are handled more elegantly and do not crash the program.
After this, the CLI work pretty well.
I did notice that the structure of this initial CLI arrangement was illogical and required to the user to input the same thing multiple times if they wanted to leave a review for example.
So I restructured the CLI so that it made more sense and so that it is more effecient with user input.
The entire program now works as it should!

## 9. Update 12/08/22

I added even more tests just to make sure that there were no bugs or errors that I was unaware of. The coverage of these tests can be seen in here.
![JavaTestReport] (images/JavaTestReport.png)



