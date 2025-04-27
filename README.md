[![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&pause=1000&width=435&lines=Alice+Game)](https://git.io/typing-svg)
<h2><a>Game-quest</a></h2>

Project for JavaRush course (module WEB) 

<h3><a>About: </a></h3>

link: https://alicegame.onrender.com
>The goal of the game is to reach the final location (London)

After initialization, the user gets to the first location (rabbit hole)
* Each location has characters, you can talk to them
* Locations have chests with items that can be pick up
* Items in inventory can be used
* Available moving between locations
* Hidden locations can be unlocked by completing a character quest


<h3><a>Building: </a></h3>
```$ docker build -t alice .```

<h3 ><a>Launch:</a></h3>
```$ docker run -p 1111:8080 alice```

link: ```localhost:1111```

<h3><a>Technologies in the project</a></h3>

- Maven
- UI: JSP, JSTL, Bootstrap, CSS
- Tests: JUnit5, Mockito
- lib's: apache-commons, lombok
