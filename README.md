# Register/LogIn/ShowUsers/LogOut Use Case

![CAExplanation](images/CAExplanation.png)

 ## 1.Packaging

    I devided my Use case into 5 packages.
    
    Frameworks & Drivers (Blue)
    cli
    userDataBase
    
    **********************************************************************
    
    Interface Adapters (Green)
    logInInterfaceAdapters

    **********************************************************************

    Application Business Rules (Red)
    logInUseCase

    **********************************************************************

    Enterprise Business Rules (Yellow)
    entities
    


## 2.Javadoc and Testing
    
    Packages that were documented using JavaDoc:

    userDataBase
    logInInterfaceAdapters
    logInUseCase
    entities
    
    **********************************************************************
    Documenting cli was omittied, is it only uses Presenter and Controller
    classes from interfaceAdapters package.

    **********************************************************************
    Tests are provided for every class and method except for the cli
    package, as testing it would be unconvinient, because the only function
    of this package is to display output and accept input from the user.

    **********************************************************************
    Unfortunately, I didn't figure out how to generate the test report, but
    all tests are runnable, and can be run by running NameOfClassTest.java.
    



## 3. CLI

![CLIExplanation](images/CLIExplanation.png)

    The following diagram explains how the CLI works.

    **********************************************************************

    I would also like to note that I made CLI the way it is open for 
    extention. For instance, and infinte amount of other options can
    be added to MainMenu, by just adding one more if statement and
    making a call of other interface that will lead user further.
    
## 4. Updates 11/29/2022

    1.CLI was simplified, by getting rid of unneeded Interfaces that 
    were passed to interfaces they call, creating a lot of 
    misunderstanding in a team regarding the use of CLI.

    **********************************************************************

    2. I also got rid of unneeded dependesies inside the project,
    so that it would follow CA more.

    **********************************************************************

    3.MVC design pattern was implemented. Before, if logInController wanted to
    output a message to CLI it had to send it to InputBoundary->Interactor->
    OutputBoundary->Presenter. Now this path is: ViewModel->Presenter.

    **********************************************************************

    4. The bug that in case that program crashes users that didn't log out
    stay logged in and it was impossible to log in using that account was
    also fixed by logging out all the users that were logged in as project
    being started.

    **********************************************************************

    5. Regarding test covrage, Interactor class was showing only 80% covrage
    as showUsers() and outputMessage(string s) were not tested. However,
    this methods only pass the information to outputBoundary, without
    modifying it in any way, hence doesn't need to be tested.


## 5. Update 12/02/2022

    All the classes and packages were refractored, to make connecting 
    UseCases more efficient.

## 6. Update 12/03/2022

    1. All the classes and methods have thorough explanation in JavaDoc,
    except for the classes in the CLI package as they do not perform
    any other calls then methods from LogInPresenter or LogInController
    classes. However, class BootCLI has JavaDoc and comments, for additional
    clarifications. Concerns regarding the import statement was adressed.
    Typos in JavaDoc and naming of some variables were also fixed. Warnings
    were also fixed. However,ther is still a warning in UserDataBase class,
    please look "WARNING" in the JavaDoc of the corresponding class.

    **********************************************************************

    2. Clarifications regarding testing covarage of the classes that are
    included in the logInInterfaceAdapter package : 

    please look "NOTE" in LogInPresenter JavaDoc(lines 15-19)

    **********************************************************************

    3. Screenshot of Junit test Report is attached below.

![CAExplanation](images/TestReport.png)

## 7. Update 12/04/2022

    Mason's branch (filter look for course) was merged to main. Some problems
    occured, but everything was fixed and the project is running without flaws.
