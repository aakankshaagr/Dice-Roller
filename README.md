# Dice-Roller
A simple app which gives a number when you roll a dice.
# My Takeaway
A Button is a user interface (UI) element in Android that the user can tap to perform an action.

When there are Views within a ViewGroup, the Views are considered children of the parent ViewGroup. In the case of your app, the TextView and Button would be considered children of the parent ConstraintLayout.Add a Button as a child of the existing ConstraintLayout in your app.
## Position the Button

In the Design view, at the top edge of the Button, press and hold the white circle with a blue border. Drag the pointer, and an arrow will follow the pointer. Release when you reach the bottom edge of the "Hello World" TextView. This establishes a layout constraint, and the Button slides up to just beneath the TextView.

## Button is horizontally centered in its parent

![image](https://user-images.githubusercontent.com/71868375/147629266-487d85b8-aa85-4f56-b0ff-d50f7f64a392.png)

In Button, the Constraint Widget should look like this. Notice two additional constraints that have been added: Start → StartOf parent (0dp) and End → EndOf parent (0dp). This means the Button is horizontally centered in its parent, the ConstraintLayout.

## Activity
An Activity provides the window in which your app draws its UI. Typically, an Activity takes up the whole screen of your running app. Every app has one or more activities. The top-level or first activity is often called the MainActivity and is provided by the project template. For example, when the user scrolls through the list of apps on their device and taps on the "Dice Roller" app icon, the Android System will start up the MainActivity of the app.

In your MainActivity code, you need to provide details on the Activity's layout and how the user should interact with it.
Note : Here,you will add code to respond to a button tap in the MainActivity. 

## Open the MainActivity.kt file
1. Look at the Kotlin code for the MainActivity class, identified by the keyword class and then the name.

`class MainActivity : AppCompatActivity() {
    ...
}`

2. Notice that there is no main() function in your MainActivity.

Earlier, you learned that every Kotlin program must have a main() function. Android apps operate differently. Instead of calling a main() function, the Android system calls the onCreate() method of your MainActivity when your app is opened for the first time.

3. Notice the lines beginning with import.

Android provides a framework of numerous classes to make writing Android apps easier, but it needs to know exactly which class you mean. You can specify which class in the framework to use in your code by using an import statement. For example, the Button class is defined in `android.widget.Button`.

**Note:** The unambiguous imports settings tell Android Studio to automatically add an import statement, as long as it can determine which one to use. The optimize imports settings tell Android Studio to remove any imports that aren't being used by your code.

The` findViewById()` method finds the Button in the layout.` R.id.button` is the resource ID for the Button, which is a unique identifier for it. The code saves a reference to the Button object in a variable called rollButton, not the Button object itself.

`val rollButton: Button = findViewById(R.id.button)`

**Note :** Android automatically assigns ID numbers to the resources in your app. For example, the Roll button has a resource ID, and the string for the button text also has a resource ID. Resource IDs are of the form `R.<type>.<name>`; for example, `R.string.roll`. For View IDs, the <type> is id, for example, `R.id.button`.

The code saves the reference to the Button object in a variable called `rollButton`, not the Button object itself.

**Important :** When it assigns an object to a variable, Kotlin doesn't copy the entire object each time, it saves a reference to the object. You can think of a reference similar to a national ID number; the number refers to a person, but it isn't the person itself. When you copy the number, you don't copy the person.
 
## OnClick event
  
Next you need to associate code with the Button, so that the code can be executed when the Button is tapped. A click listener is some code for what to do when a tap or click happens.
  
Use the `rollButton` object and set a click listener on it by calling the `setOnClickListener()` method. Instead of the parentheses following the method name, you will actually be using curly braces following the method name. **This is a special syntax for declaring a Lambda**, which you'll learn more about in a future codelab.
What you need to know for now is that within the curly braces, you put instructions for what should happen when the button is tapped. You'll have your app display a Toast, which is a brief message in the next step.


`rollButton.setOnClickListener {
}`
  
## Creating Toast Message
  
Create a Toast with the text "Dice Rolled!" by calling Toast.makeText().

`val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)`
  
Then tell the Toast to display itself by calling the show() method.

`toast.show()`

## Update the TextView when the Button is clicked
  
 Instead of showing a temporary Toast message, you'll write code to update the `TextView` on screen when the `Roll` button is clicked.
 In toast place, create a new variable called `resultTextView` to store the `TextView`.
  
1. Use `findViewById()` to find textView in the layout using its ID, and store a reference to it.

`val resultTextView: TextView = findViewById(R.id.textView)`
  
2. Set the text on resultTextView to be "6" in quotations.
  
`resultTextView.text = "6"`
  
This is similar to what you did by setting the text in Attributes, but now it's in your code, so the text needs to be inside double quotation marks. Setting this explicitly means that for now, the `TextView` always displays 6.
  
## Add the dice roll logic
 Add the Dice class
    After the last curly brace in the MainActivity class, create the Dice class with a roll() method.

  `class Dice(val numSides: Int) {

   fun roll(): Int {
       return (1..numSides).random()
   }
}`
  
  
**Notice that Android Studio may underline numSides with a wavy gray line. (This may take a moment to appear.)**
Hover your pointer over numSides, and a popup appears saying Property ‘numSides' could be private.

  ![image](https://user-images.githubusercontent.com/71868375/147631027-de2fbbf6-b423-4826-ba33-693dc240f978.png)


Marking numSides as private will make it only accessible within the Dice class. Since the only code that will be using numSides is inside the Dice class, it's okay to make this argument private for the Dice class. You'll learn more about private versus public variables in the next unit.

Go ahead and make the suggested fix from Android Studio by clicking Make `numSides` `private`.

  ## Create a rollDice() method
  
  Now that you've added a Dice class to your app, you'll update MainActivity to use it. To organize your code better, put all the logic about rolling a dice into one   function.

1. Replace the code in the click listener that sets the text to "6" with a call to `rollDice()`.
`
rollButton.setOnClickListener {
   rollDice()
}
  `
  
Because `rollDice()` isn't defined yet, Android Studio flags an error and shows `rollDice()` in red.
If you hover your pointer over rollDice(), Android Studio displays the problem and some possible solutions.
  
![image](https://user-images.githubusercontent.com/71868375/147630952-99872b8c-ed15-4c35-bd68-cf4de38853b3.png)


`Click on More actions...` which brings up a menu. Android Studio offers to do more work for you!
  
Tip: If you find it difficult to hover the pointer and then click on `More actions...` you can click on `rollDice()` and press `Alt+Enter` (Option+Enter on a Mac) to bring up the menu.



2. Select Create function `rollDice`. Android Studio creates an empty definition for the function inside MainActivity.
`
  private fun rollDice() {
    TODO("Not yet implemented")
}
  `
## Create a new Dice object instance
In this step you'll make the rollDice() method create and roll a dice, and then display the result in the TextView.

3. Inside rollDice(), delete the TODO() call.
  
4. Add code to create a dice with 6 sides.
  
`val dice = Dice(6)`
  
5. Roll the dice by calling the roll() method, and save the result in a variable called diceRoll.
  
`val diceRoll = dice.roll()`

6. Find the TextView by calling findViewById().
  
`val resultTextView: TextView = findViewById(R.id.textView)`
  
The variable diceRoll is a number, but the TextView uses text. You can use the toString() method on diceRoll to convert it into a string.

7. Convert diceRoll to a string and use that to update the text of the resultTextView.

  `resultTextView.text = diceRoll.toString()`
  
This is what the rollDice() method looks like:

`
  private fun rollDice() {
    val dice = Dice(6)
    val diceRoll = dice.roll()
    val resultTextView: TextView = findViewById(R.id.textView)
    resultTextView.text = diceRoll.toString()
}`
  
Run your app. The dice result should change to other values besides 6! Since it is a random number from 1 to 6, the value 6 might appear sometimes, too.

    ![image](https://user-images.githubusercontent.com/71868375/147751656-9ea6ed25-132e-4beb-abcc-faeccebaec91.png)

 
## Use a when statement
Testing for many different outcomes, or cases, is very common in programming. Sometimes, the list of possible outcomes can be very long. For example, if you were rolling a 12-sided dice, you'd have 11 else if statements between the success and the final else. To make these kinds of statements easier to write and read, which helps avoid errors, Kotlin makes available a when statement.
 
 As before, first test whether rollResult is the same as the luckyNumber.

Inside the curly braces {} of the when statement, add a statement that tests rollResult against luckyNumber, and if they are the same, print the winning message. The statement looks like this:

`when(RollResult){
    luckyNumber -> println("You win!")
    }`
This means:

You first put the value you are comparing to `rollResult`. That's luckyNumber.
Follow that with an `arrow` (->).
Then add the action to perform if there is a match.
Read this as, "If rollResult is luckyNumber, then print the "You win!" message."
    `when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! You rolled a 6. Try again!")
    }`

Hooray, you rock!

    Note:  1. Writing  parameter type is important in class and return function.
                2. Classes can be wriiten in seperate file or outside in main activity file.
                3. You need to adjust text size box to fix value in it otherwise number will appear below each other doesn't matter input type is string or numbers.
                4. since input type is string we are using toString() method to convert from number to string.
