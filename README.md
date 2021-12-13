# PlanIt

<!--- These are examples. See https://shields.io for others or to customize this set of shields. You might want to include dependencies, project status and licence info here --->


The project name are PlanIt. It is a web application, that enables users to do project calculation. The user will be able to create a user profile and then login. Once logged in the user can create his own project, add a timeline for the project and create task and subtasks to fullfill the project. The application will then perform calculations to provide the user with information about the estimated time and price for the project. The core is to give the user an overview on the created project and present it by using an Interface. 

Our application are mainly build in Java with the Spring Framework, Maven and connected to a Database. It is currently uploaded to Github, hosted on Heruko and uses a AWS Database ( Heroku is a platform as a service (PaaS), that enables developers to build, run, and operate applications entirely in the cloud.
Guide for cloning this project and hosting your own version on Heruko is provided in the end of this README file ).

The application can be accessed directly from a web browser by providing the correct URL.

Note: If you are a developer and knows how to handle SQL scripts, this application comes with two prepared SQL script, a DDL and DML. Please read " ##developer installing " below for instructions on how to run the scripts, set up the database structure and the testdata for your own local developer enviroment.



## Prerequisites

Before you begin running this program, ensure you have meet these basic requirements:
<!--- These are just example requirements. Add, duplicate or remove as required --->

* You have a Linux, windows or macOS machine.
* You have installed the latest version of Java.
* You are connection to the Internet and have a browser installed.
* You have read this README file.

Developer install ekstra prerequisites:
* You have version control installed ( GIT ).
* You Have en Editor installed like IntelliJ or Eclipse.


## Installing

To install PlanIt, follow these steps:

Linux, windows and macOS:

```
No installation requirements, but must meet the prerequisites as listed above. 
```

## Developer Installing

To install PlanIt with autocreating the database and testdata using SQL scripts, follow these steps:

1. Clone this Github repository to your local computer.
2. Open the project in your prefered editor ( this guide is with IntelliJ ).
3. Connect your local database opening the " application properties " and fill in the required informations:
etc: 
url=jdbc:mysql://localhost:3306/PlanIt?serverTimezone=UTC 
user=<Yourname>
password=<Yourpassword>
server.port=8080 ( optional, because default port is 8080 )
4. Run the DDL and DML script. ( The DDL script will create your database, schema, constraints, users, tables etc.. The DML script will create the testdata like  inserting, update or delete records ). Your can run the script in your MYSQL workbench by opening the script, and press the " execute all " button. You can also run the script in your editor like IntelliJ in your query console.
5. Once the script has created the database with testdata you can run the Spring application in your editor and then fill in this adress http://localhost:8080 in your browser to run the web application with your own local Database.
6. Enjoy!

  
## Using

To use PlanIt, follow these steps:

```
Fill in the provided URL in your browser.

```


## How to host this project on your own Heruko account 

If you are allready setup with GitHub and Heruko accounts skip this first section and and jump to "Host to Heruko Guide".

* You need to have your own Github Account
--> If you dont have an account sign up for free by following in this link: https://www.wikihow.com/Create-an-Account-on-GitHub
* You need to have your own Heruko account.
--> If you dont have an account sign up for free by following this link: https://signup.heroku.com
* You need to clone this git repository named PlanIt and insert into a new repository on your own Github account.
--> If you havent done that before follow this guide.https://git-scm.com/book/en/v2/Git-Basics-Getting-a-Git-Repository


Host to Heruko guide: 

1. Sign into Heruko and your Dashboard should look like this ( I allready have six apps, so just ignore that:-D ).
<img width="1430" alt="Heruko guide 1  step" src="https://user-images.githubusercontent.com/82437282/143500437-d3216145-eba3-4639-883a-05fbceba55f7.png">

2. Choose " New " then --> " create new app " in the upper right corner.
<img width="1428" alt="Heruko guide 2  step" src="https://user-images.githubusercontent.com/82437282/143500731-9d9835b7-fff7-457f-8cb0-f69848eb2b97.png">

3. Provide a name for your app and your location and press " create app".
<img width="1438" alt="Heruko guide 3  step" src="https://user-images.githubusercontent.com/82437282/143500898-4cdafb53-fdcf-4464-a9b4-35deb567fb0d.png">


4. You created your app and you should get this picture. Press " connect to Github "
<img width="1431" alt="Heruko guide 4  step" src="https://user-images.githubusercontent.com/82437282/143501095-478e0caa-4aa6-4b3b-b414-6b957b218477.png">

5. Search for the Github repository you want to host ( Must be correct spelled ) and press " connect " and you will get this picture.
<img width="1429" alt="Heruko guide 5  step" src="https://user-images.githubusercontent.com/82437282/143503076-52429ebc-06e9-4964-968a-564fc65610a3.png">

6. Make sure to choose the " main " branch ( sometimes called master ) and press "deploy branch ". Heruko will do some behind the scenes stuff and build your website:
<img width="1435" alt="Heruko guide 7  step" src="https://user-images.githubusercontent.com/82437282/143502001-456eb8f8-be79-41fe-ad98-a16048259591.png">

7. Press the " view button " 
<img width="1433" alt="Heruko guide 8  step" src="https://user-images.githubusercontent.com/82437282/143502342-735e307f-fbd2-411f-a809-98d6efaa0b30.png">

Voila Your project are succesfully hosted and Heruko will display in your browser and you will get an URL that looks something like this: 
https://herukotestguide.herokuapp.com



## Contributing to PlanIt

<!--- If your README is long or you have some specific process or steps you want contributors to follow, consider creating a separate CONTRIBUTING.md file--->

This is a public Github repository and you will be able to contribute.

To contribute to PlanIt, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the original branch: `git push origin <project_name>/<location>`
5. Create the pull request.

Alternatively see the GitHub documentation
on [creating a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request)
.

## Contributors

Thanks to the following team, who have contributed and build this project:

* [@ChristopherDN](https://github.com/ChristopherDN) 👊🏻👨🏻‍💻
* [@Geofery](https://github.com/Geofery) 👊🏻👨🏻‍💻
* [@jeppe-t](https://github.com/jeppe-t) 👊🏻👨🏻‍💻

the [All Contributors](https://github.com/all-contributors/all-contributors) specification and
its [emoji key](https://allcontributors.org/docs/en/emoji-key).

## Contact

If you want to contact the team you can reach us at KEA.

## License

<!--- If you're not sure which open license to use see https://choosealicense.com/--->

This project uses the following license: PlanIt_KEA_Project.
