# Knomatic Android Code Challenge
This repo contains the Knomatic Android code challenge.  

## Task
Your task is to modify this application so that it tells the current and forecast weather at the user's location.  You will need to get the user's GPS location and then use that to contact the [Dark Sky Forecast API](https://developer.forecast.io/) and display the weather and forecast. After that is completed, please complete the questionnaire at the bottom of this readme file.  Please include your answers inline in this file.

Your time is valuable and we understand that.  Our goal is for you to spend about three hours working on this task.  If you are having fun and want to take it farther feel free, but it's not required. Our evaluation criteria are listed below.  Please make sure that all of the evaluation sections are included.  And to be clear we don't expect them to be 100% production ready, just enough to show that you know what you're doing in each area.

**_A note about the Dark Sky Forecast API Key_**:
[The Dark Sky Forecast API](https://developer.forecast.io/) has free tier that allows about 1000 calls a day, you can sign up for an API key today without giving them any payment details.  If this changes or you have a problem, please email us and we will get you an API key.

## Requirements
- You must finish this application so that it can contact the [Dark Sky Forcast API](https://developer.forecast.io/) for the users location, and display the current weather and the forcast.
- Your submission must be a fork of this repo and a submitted as a pull request on GitHub
- You should add any needed screens/UI elements
- You should support both Tablets and Phones, but doesn't have to perfect
- You must answer the questions inline in this file.

## Notes and Hints
- Use Android Studio's code generation where you can.
- You may use any JSON library you want
- You may use any other open source libraries you want
- Its nice when things look nice, but we know you're not a designer.  A set of weather icons can be found here: http://adamwhitcroft.com/climacons/ and a design mock of our checkin weather screen is included in this repo at /mock.png .  Your app dosn't need to look like the mock, its just for inspiration to help get you started.   

## Evaluation
-   Correct Use of Fragments
-   Correct Use of Activities
-   Correct Use of Layouts
-   Correct Use of Styles and Other Resource Files
-   Correct Use of JSON API's
-   Correct Use of Location Services
-   Correct use of Application and fragment contexts.
-   Use of Android Compatibility Framework.
-   How is state passed between activities
-   How is the JSON deserialized
-   Markdown formatting
-   Defensive programming   (App shouldn't crash if GPS or network is off)

## Bonus Points
-  Some working unit tests!  

## Questions to Answer
Please answer the following in about a paragraph.

1.  How long did you spend on completing this challenge? I Spent 11 hours in this challenge
2.  How far were you at 3 hours? In 3 hours, I had the User Location, and I had integrated Retrofit API in the app, and I obtained the Service Data, but in that moment I didn't have any screen developed. I spent time finding the best way to return the data from the service in a service layer, but it didn't work as I expected, so I continued.
3.  What needs to be finished/fixed for this to be used in a production app? To be used in a production app, I have to finish some validation data, and show to user for example an option to turn on GPS or Wifi. I have to translate all Strings and put in a String.xml file to support all languages. Maybe showing an option to change Farenheit to celsius degree. All the drawable resource have to be in diferent sizes to support all screens. 
To improve the graphic interface for the user and implement more test cases.
4.  What did you think of this challenge? I think that this challenge evaluate many aspects in the lifecycle in the android app development.
5.  What part was unclear? I think that the main objective of this challenge was clear, maybe the API documentation in the data that service returned was unclear to show to user, because it uses technical information that I don't understand very well.
6.  What could we do to make this challenge better? A brief documentation of data that service return or what information can be relevant to show in user's interface. An option that the user can change between Celsius and Farenheit degrees.
7.  What did we forget to test you on? Integration with other services like: OAuth, google maps, and SQLite.
