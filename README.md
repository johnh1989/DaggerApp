# DaggerApp
Application demonstrating how to leverage Dagger and MVP to build and test an android app.

#Preface
 - To run the app in live mode, run the devDebug flavor
 - To run the app using 100% mocked data (never makes a network call thanks to dependency dnjection tricks),
 run the tddDebug flavor. Following TDD, we can write our tests, and modules which provide mocks, and run the app
 without ever needing to make a network call, or talk to a local database. This enable for not only fast manual testing,
 but the ability to have regression tests in place, IE: when you make changes, you can run your tests and know if something broke :)

##TODO Complete a matching blog post about TDD, Dagger, and clean architecure

- create another screen, maybe with different data
- create POJO test module to provide dummy data inside of tests
- write android tests and implement jacoco test coverage
- write junit/roboelctric tests 
- process requires some boiler blate code in android tests. Describe how to create live templates to create boiler plate code
- make sure to note that if you are writing a test and extending your component, when you annotate that interface with @Component, make sure its importing dagger.component and not the one from espresso!!!