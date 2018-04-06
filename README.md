# Problem statement
Develop an API that moves an electronic rover around on a grid based on passed instructions.

# Contract/Rules to be considered
•	The program will receive starting point coordinates (x,y) of a rover along with the direction (N,S,E,W) it is facing.
•	The rover receives a character array of commands
•	Movement will be relative to the previous point and the rover should always maintain it’s latest coordinates (assume grid is rectangular and has data points starting from (0,0) to infinity.
•	Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.

# Technology Stack
The project uses the following technologies: <br/>
- **development**: [java](https://java.com/en/download/) <br/>
- **build**: [maven](https://maven.apache.org/)<br/>
- **testing**: [junit](http://www.junit.org/), [assertJ](http://joel-costigliola.github.io/assertj/) <br/>

# IDE
- see the [IntelliJ for Spring page](https://www.jetbrains.com/help/idea/spring.html)

# Test
 mvn clean test

# NOTES
Command parsing of char array in not done and the api is kept strongly typed