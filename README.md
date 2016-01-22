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
* 35 minutes between end of one showtime and the start of the next. 
* Movies should be scheduled as late as possible so prime-time evening hours are maximized.
* Early hours scheduled last.
* Showtimes should start at easy to read times (2:35 is preferred to 2:37).

### Theatre Hours
```sh
Monday - Thursday 11:00am - 11:00pm
Friday - Sunday 10:30am - 11:30pm
```

# Example
Run in command prompt: 
```sh
[Directory Path\..]>javac Theatremanagement.java
[Directory Path\..]>java TheatreManagement dmynd.txt
```

Input (dmynd.txt):
```sh
Movie Title, Release Year, MPAA Rating, Run Time
There's Something About Mary, 1998, R, 2:14
How to Lose a Guy in 10 Days, 2003, PG-13, 1:56
Knocked Up, 2007, R, 2:08
The Wedding Singer, 1998, PG-13, 1:36
High Fidelity, 2000, R, 1:54
Sleepless in Seattle, 1993, PG, 1:46
The Proposal, 2009, PG-13, 1:48
```

Output:



```sh
Thursday 1/21/2016

There's Something About Mary - Rated  R,  2:14
12:15 PM - 02:29 PM
03:05 PM - 05:19 PM
05:55 PM - 08:09 PM
08:45 PM - 10:59 PM

How to Lose a Guy in 10 Days - Rated  PG-13,  1:56
01:15 PM - 03:11 PM
03:50 PM - 05:46 PM
06:25 PM - 08:21 PM
09:00 PM - 10:56 PM

Knocked Up - Rated  R,  2:08
12:35 PM - 02:43 PM
03:20 PM - 05:28 PM
06:05 PM - 08:13 PM
08:50 PM - 10:58 PM

The Wedding Singer - Rated  PG-13,  1:36
12:20 PM - 01:56 PM
02:35 PM - 04:11 PM
04:50 PM - 06:26 PM
07:05 PM - 08:41 PM
09:20 PM - 10:56 PM

High Fidelity - Rated  R,  1:54
01:35 PM - 03:29 PM
04:05 PM - 05:59 PM
06:35 PM - 08:29 PM
09:05 PM - 10:59 PM

Sleepless in Seattle - Rated  PG,  1:46
01:55 PM - 03:41 PM
04:20 PM - 06:06 PM
06:45 PM - 08:31 PM
09:10 PM - 10:56 PM

The Proposal - Rated  PG-13,  1:48
01:55 PM - 03:43 PM
04:20 PM - 06:08 PM
06:45 PM - 08:33 PM
09:10 PM - 10:58 PM
```

