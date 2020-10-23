### WHAT IT DOES

Our project is designed to let a user setup text-based alarms to themselves.  In particular, a user can designate an alarm to repeat itself several times, at a rate of the user’s choosing.


### HOW IT WORKS

Starting with the database, we have two tables.  The first one is named UserData, which we use to store a user’s phone number and password for 
verification purposes.  Any time our project needs a new user created, a user removed, a password changed, or a confirmation that a user’s data 
exists in the database, this table gets called. We also have one called AlertRequest that stores all the information each alert needs in order 
to be sent properly, such as the date and time the message is to be sent, which phone number to send it to, how often it repeats, how many minutes 
are between repeats, and of course the message of the alert itself.  Our database also generates a unique alertID for each alert to make sure we 
can uniquely reference it.  Connecting to both of these is our InformationAPI, which manages all endpoints connecting to these tables.
	
Information API is used to interact with the two database tables.  Most of the flows for this API allows a user to interact with the database, by creating or deleting a user, changing a user’s password, and by creating, deleting, or editing an alert.  These flows will be discussed in more detail under the How To Use It section.  There is one flow outside of this list referred to as alert/run.  This flow is designed to work outside of user interaction and is used to regularly request data from the database.  In particular it checks the current date and time as of the request and compares it to all of the alerts in the AlertRequest table.  If there are any alerts that have a matching date and time, it calls the external Twilio API to text the message in that row to the phone number in that row and decrements the repeatcount of the alert.  Should the repeatcount fall below 1, the alert is subsequently deleted to free up space, otherwise the date and time of the alert is incremented by a number of minutes equal to the repeatincrement.  In order to make sure this flow is called regularly, we have a Timepiece java class running outside of the server that creates an indefinite loop designed to make a GET request to the alert/run flow at a set interval.


### HOW TO USE IT

Each of the flows listed below are designed to make a request to the database when provided with the correct information.  While many of these flows make POST requests, they are able to use GET requests as well if you’re not sure what kind to make.  Each endpoint needs to start with http://3.133.151.211:8081

/user/add
	Allows the addition of a new user by taking a phone number and password as a JSON payload as shown below.  Phone numbers should start with +1 to work properly with Twilio.
	
{
	“pn”:” +10001112222”,
	“pw”:”lamePassword1”
}



/user/editPassword
Allows a user to change their password by using their phone number as a reference in the database.

{
	“pn”:”+10001112222”,
	“newPw”:”lamerPassword1”
}



/user/delete
	Removes a user’s phone number and password from the UserData table when provided with the phone number.  In the event that they still have entries in the AlertRequest table, those will be removed as well.
	
{
	“pn”:”+10001112222”
}



/user/search
Returns true if the provided phone number and password match a row in the UserData table, false if such a row is not found.

{
	“pn”:”+10001112222”,
	“pw”:”lamePassword1”
}



/alert/add
	Creates an alert in AlertRequest based on a provided phone number, message, datetime, repeatincrement, and repeatcount.  An alertID will be automatically provided.  Datetime should be formatted as MM/DD/YYYY HH:MM AM, with HH being single digit if not 10, 11, or 12 and AM being PM if at night.  The following example will text (000)-111-2222 at 5:30PM and 5:35PM on the 16th of March with a reminder to switch their laundry.
	
{
	“phone”:”+10001112222”,
	“message”:”Reminder to switch laundry”,
	“datetime”:”03/16/2020 5:30 PM”,
	“repeatcount”:”2”,
	“repeatincrement”:”5”
}



/alert/phone/{phone}
	A function that will allow a user to see an array of all their alerts simply by providing their phone number in the URI, no payload required.  Note that in the return message, repeatNum represents repeatcount and repeatTime represents repeatincrement.
	After the alert/add example is used, going to /alert/phone/+10001112222 will return:
	
[
    {
        "phone": "+10001112222",
        "message": "Reminder to switch laundry",
        "id": 10,
        "repeatNum": 2,
        "dateTime": "03/16/2020 5:30 PM",
        "repeatTime": 5
    }
]



/alert/edit
Allows the user to modify one cell of an alert, in case they change their mind of how they want the alert to look or act.  The id refers to the alertID, the column is which part of the alert they wish to change, and the newvalue is what you want that cell to now contain.

{
	“id”:”10”,
	“column”:”message”,
	“newvalue”:”Good afternoon”
}



/alert/delete/{id}
	Allows swift removal of an unwanted alert by presenting the alertID in the URI.  Removing the example alert is as easy as the following:
	
/alert/delete/10



### FUTURE IMPROVEMENTS

The main thing we wish to improve upon for this project is to integrate a front end.  We originally were planning on doing so but did not have it fully operational in time.  We would also like to provide greater significance to logging in.  At present, the only security for creating an alert is that the phone number provided must already be in the database, and the only criteria for deleting or editing an alert is that you must know the id number of the alert you wish to modify.  While not very RESTful, we could potentially store a session variable from when the user logs in that stores the phone number of the user, and commands for creating, editing, and deleting alerts could require this value to be passed in without being able to be manually entered by the user.


### Developer Team: ###
#### *Reynaldo D.,  David K., Kat L., and Ryan L.* ####
