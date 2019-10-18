# Sprint-Android-Advanced-Kotlin-Challenge

## Instructions

**Please read this entire README to make sure you understand what is expected of you before you begin.**

This sprint challenge is designed to ensure that you are competent with the concepts taught throughout the Advanced Kotlin sprint.

In your solution, it is especially important that you follow best practices such as MVC and good, consistent code style. You will be scored on these aspects as well as the project MVP (minimum viable product) requirements below.

Fork this repository and clone your fork to your computer. Create a new Android Studio project in this cloned fork repository folder, then commit and create a pull request. Commit appropriately as you work. When finished, push your final project to GitHub and comment on the pull requestto indicate that your project is complete.

You have *3 hours*, and you should work *independently* — looking things up (search, notes) is all fair game. And questions about *process* / *logistics* (i.e. if you have a hard time opening/saving to GitHub) are fair game too.

Good luck!

## Screen Recording

This screen recording shows how the app should look. Use this when designing your test cases. 

<img src="MatricesRecording.gif" width="300">

## Requirements

The goal of this application is to allow users to multiply matrices together and view the result on a separate page.

The requirements for this project are as follows:

1. Create a custom Matrix class which will.  
    * Store matrixes in a 2-dimentional array
    > This line `Array(height) { Array(width) { 0 } }` will declare an array of size `height` x `width` and fill it with 0s
    * Overload the * and index operators
    > This page will provide information on overloading the index operator (https://kotlinlang.org/docs/reference/operator-overloading.html)
    * Include height and width properties with setters that will resize your matrix data array when they're changed
    > To resize an array, you'll need to create a second array of the bigger size, copy the old array data to it, and then replace the property the value of the new array (=)
2. One controller which will show 2 matrices at once and a button to perform the calculation
    * The user must be able to edit the values in the matrices
3. Another controller which will show the result of the calculation as another matrix
    > You may have issues rebuilding your first controller after returning from your second one, a few tips:
    > * Don't do controller interactions in `onChangeEnded` this triggers both when the controller is being created and another one is replacing it
    > * If you use child controllers, be sure construct them with `setPopsLastView(true)` and to clear them with `popCurrentController` to allow you to rebuild them
4. Use `by lazy` and `lateinit` on class properties

## Go Further (Stretch Goals)

* Allow users to change the size of the matrices in the UI
