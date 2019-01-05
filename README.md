# RecyclerViewBoilerPlateApp
This is boilerplate code for RecyclerView.

I created this app because I use the same boilerplate code over and over again when creating a list activity.  


##For a RecyclerView using an ArrayList:
Copy the contents of the folder recyclerviewarraylist (app/src/main/java/com.samuelbeck.adapterfram/recyclerviewarraylist) into the folder you are going to user for your recyclerview.  The layout folders has the sample xml.  

Rename everything that has RecyclerViewArrayList to YourActivityName. 

Change out xml info in Activity and Adapter

Clear out non-boilerplat code

update package
update imports

(Mayby I should add one more folder with all of the non-boilerplate code cleared out)



##For a RecylcerView using a Cursor
Copy the contents of the folder recyclerviewcursorlist (app/src/main/java/com.samuelbeck.adapterfram/recyclerviewcursorlist). The layout folders has the sample xml.


Rename everything that has RecyclerViewCursorList to YourActivityName.

Change out xml info in Activity and Adapter

Clear out non-boilerplat code

update package
update imports

(I really should add another folder with all of the non-boilerplate code cleared out)


 
##Explanation

The activity holds an observer for the viewmodel that implements livedata

LiveData will update the observer in the activity if the data is updated

The ViewModel will reference the Repository (Model part of MVVM) and let model handle data sorting and retrieval.

When the repository/model updates  the viewmodel, the activity is updated through is observer.

The adapter has an interface to the activity.  This eliminates having a reference to the Activity and eliminates memory leaks from forgetting to eliminate the Activity reference in the adapter. (if you want to pass in the activity... just remember to null the reference to the activity in the adapter in onDestroy of the activity.)


##PS
I removed some of the non-boilerplate code and put it in boilerplate_....


