# CSC207 Project 
# Team NPCs (Mykola, Mason, Michael, Elang, Shawn, John)


## KolyaLovesMarlboro(Mykola Zhuk on Quercus contributions):
I implemented 1st branch that was merged to main(1-log-in) which included Register/LogIn/ShowUsers/LogOut use cases.
I also made the base of the CLI(WelcomeMenu, MainMenu,Login,Register,ShowUsers classes). I tried to make the CLI as 
modular as possible, so that my teammates wouldn't have any trouble merging with main. I believe it was a great success
as we managed to merge all the leftover branches the day before the deadline. I won't say a lot about my use case as
I made a separate README.md file which you can find inside my branch. Which has initial explanation of the implementation
of the use case and CLI, and Log indicating updates and explanation to them.

When I finished my use case I mostly focused on debugging, reviewing, solving conflicts ,cleaning branches from local 
files (.xml for example, or gradle/wrapper directory). You can see  significant amount of my commits in 6-filter-course 
and view-course branches. Overall, I tried to give maximum support to my teammates, so that we wouldn't leave this 
project unfinished.

##

            ___________
           |.---------.|
           ||         ||
           ||  TIRED  ||
           ||         ||
           |'---------'|
            `)__ ____('
            [=== -- o ]--.
          __'---------'__ \
         [::::::::::: :::] )
          `""'"""""'""""`/T\
                         \_/


## KenanBogopa (Elang Bogopa on Quercus Contributions):
My completed UseCase (4-Leave-Review) was not directly pulled on to main but was instead merged with (22-viewcourselikereview) which can be seen when seeing the commits done on that branch.
This branch was then merged with main. Please see the README in LeaveReview as it goes more into detail with the changes that I made with my code.
I also cleaned up everyone's CLI by :
- Ensuring that there is no User Input that can cause the program to crash which made the program much less vulnerable. This was mainly done by switch from int scanners to String scanners and then checking if the Strings where indeed integers.
- Renaming all input prompts so that the structure of the CLI is consistent throughout the whole program.
- Changing the arrangement of CLI components sos that it follows a logical and efficient order to reduce the User having to input the same response more than once.

## Shawn Davison (Shawn Davison on Quercus Contributions):
My completed UseCase (22-view-courselike-review) was the final file merged onto main. It is the implementation for the
view course and like review use cases. It was created from the progress made in view-course, which was Initally Alexa's Use Case and
mine was Banuser. However Alexa stopped communicating with our group, and as such, I was forced to abandon my use case, and
complete hers. In this Use Case there is testing for both View Coruse and Like Review. 
