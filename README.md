# Tech-Reviewing-Application

This is a simple web application project desiged for HCL training program which deveoped acording to Spring Web MVC architecture.

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
/user/login - login page <br>
/user/register - registration interface <br>
/user/profile - user account page <br>
/posts/new-post - creat a post <br>
/posts/manage - manage published posts <br><br>
/posts/update?id={id} - update specific post <br>
/posts/delete?id={id} - delete specifc post <br>
/posts/view?id={id} - view specifc post <br>


