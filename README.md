# Tech-Reviewing-Application (TechZONE)

TechZONE is a Tech-Reviewing web application project designed for HCL training program which developed according to the Spring Web MVC Architecture.

#### Application Scenario -
User can registered to the system as a noramal user (Tech Reader) or as a Publisher.
An user can create a Tech Post by login with publisher account. 
Any users have access to view tech post and add comments to that post.
Also users can see upcomming Air-Dates about specific technology or gadget or programming language by navigating to the Calendar interface.

#### Used Technologies

* Spring Web MVC
* SPring JDBC
* Oracle Database

#### Routes

/home - home page <br>
/calendar - Airdates calendar page <br>
/user/login - login page <br>
/user/register - registration interface <br>
/user/profile - user account page <br><br>
/posts/new-post - creat a post <br>
/posts/manage - manage published posts <br>
/posts/update?id={id} - update specific post <br>
/posts/delete?id={id} - delete specifc post <br>
/posts/view?id={id} - view specifc post <br>


### How To Run

* Step1 - Download or clone the project
* Step2 - import the project on Eclipse IDE by navigating file -> Open project file system
* Step3 - update the project dependancies by navigating (right click on project folder -> maven -> update)
* Step4 - configure the tomcat server(v9) by navigating project build path
* Step5 - finaly run the project by right click project -> run as -> run on server
