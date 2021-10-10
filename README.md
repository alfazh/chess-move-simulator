# Chess Move Simulator Application 

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Setup](#setup)

## Introduction
This application simulates chess moves for 3 types (king, queen, pawn) of chess pieces on an empty 8X8 chess board. The application has a CLI interface that allows for an input specification of a chess piece and position on chess board. It will display the possible moves based on the given piece and position (if any exist). 

## Technologies
Java version: 14
Spring Boot version: 2.5.5

## Setup
This is a maven project that can be built using below command 
```
mvn package
```

## Launch 
Once artifacts are created via maven build, the application can be executed as below 
```
java -jar chess-move-simulator-0.0.1-SNAPSHOT.jar <piece>,<position>
Eg. java -jar chess-move-simulator-0.0.1-SNAPSHOT.jar Pawn,A1
```
