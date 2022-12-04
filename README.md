[![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&pause=1000&width=435&lines=Alice+Game)](https://git.io/typing-svg)
<h2><a>Web game application with quests</a></h2>

After initialization, the user gets to the first location (rabbit hole)

>The goal of the game is to reach the final location (London)
>  
* Each location has characters, you can talk to them
* Locations have chests with items that can be pick up
* Items in inventory can be used
* Available moving between locations
* Hidden locations can be unlocked by completing a character quest

<h3 ><a>Deployed app</a></h3>
link: https://alicegame.onrender.com

<h3><a>Building: </a></h3>

```$ docker build -t alice .```

<h3 ><a>Launch:</a></h3>

```$ docker run -p 1111:8080 alice```

link: ```localhost:1111```


<h3 ><a>Class description</a></h3>
>root of the project:
- ```main``` - application code directory
-  ```test``` - test code directory

>```main/java/com/javarush/AliceGame```:
- ```dates``` - contains the structures of the main objects of the application
- ```exceptions``` - contains possible errors from the application
- ```service``` - contains the business logic of the application
- ```servlits``` - servlet subpackage

also, at the root of the package are classes:

- ```AppContextListener``` - loads application data into the context
- ```GameMap``` - contains application content
- ```UserRepository```

>```main/resources``` contain: log4j2.xml
>

>```src/main/webapp/WEB-INF```:
- ```dialog.jsp``` - dialogs with personages
- ```finish.jsp``` - result of game
- ```gameInfo.jsp``` - persistent data (imported into other jsp documents)
- ```index.jsp``` - location, its data and user data
  
<h3><a>Technologies in the project</a></h3>

- Maven
- UI: JSP, JSTL, Bootstrap, CSS
- Tests: JUnit5, Mockito
- lib's: apache-commons, lombok

Test Coverage Jacoco:
![Alt-coverage](https://drive.google.com/file/d/1plA16QNU0sUm12jSsH-84SaJ4bT7Wo5R/view?usp=share_link" "coverage")
