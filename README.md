# First day as TheatreManager?

TheatreManager replaces manual systems by taking in a single text file and returning a schedule under business rules.

###To Start
* 1) Open command prompt
* 2) Navigate to directory containing TheatreManagement.java
* 3) Type in: 
```sh
javac Theatremanagement.java
```
* 4) Then type in:
```sh
java TheatreManagement dmynd.txt
```
> (Note: If you'd like to use your own file, make sure to save it in the same directory as TheatreManagement.java)


### Business Rules
* A movie cannot end after the theater closing time.
* All theaters close before midnight.
* When the theater opens it takes one hour to setup the theater before any movies can be shown.
* Theater cleanup, change over work, and previews require a combined 35 minutes between the end of one showtime and the start of the next. 
* Movies should be scheduled as late as possible so prime-time evening hours are maximized.
* Early hours scheduled last.
* Showtimes should start at easy to read times (2:35 is preferred to 2:37).

### Theatre Hours
```sh
Monday - Thursday 11:00am - 11:00pm
Friday - Sunday 10:30am - 11:30pm
```
