# Register/LogIn/ShowUsers/LogOut Use Case

![CAExplanation](images/CAExplanation.png)

 ## 1.Packaging

    I devided my Use case into 5 packages.
    
    Frameworks & Drivers (Blue)
    cliShawn
    userDatabase
    
    **********************************************************************
    
    Interface Adapters (Green)
    interfaceAdapters

    **********************************************************************

    Application Business Rules (Red)
    loginUseCase

    **********************************************************************

    Enterprise Business Rules (Yellow)
    loginEntities
    


## 2.Javadoc and Testing
    
    Packages that were documented using JavaDoc:

    userDatabase
    interfaceAdapters
    loginUseCase
    loginEntities
    
    **********************************************************************
    Documenting cliShawn was omittied, is it only uses Presenter and Controller
    classes from interfaceAdapters package.

    **********************************************************************
    Tests are provided for every class and method except for the cliShawn
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
    
