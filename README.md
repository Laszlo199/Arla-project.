# Arla Screens Project

## Table of contents
* [General information](#general-information)
* [Technologies](#technologies)
* [Problem Statement](#problem-statement)

## General information
Project was made in close collaboration with Arla company. It was being developed in a three people team using Scrum methodology. 
It's an exam project for the 1st year of Computer Science course at Business Academy Southwest. The main objective was
to provide functionality to show various data on muliple screens. 

## Technologies
Project is created with JavaFX. For the database side we used JDBC library. For unit tests we used JUnit library. 
* javafx version: 15
* mssql-jdbc version: 9.2.1.jre15
* junit version: 5.4.2
* jfoenix version: 9.0.1
* jfree version: 2.0.1

## Problem Statement
Problem statement provided by Arla Company. 

The clients are mostly read-only, however simple changes might be desirable, like clicking a part of program to view the data full screen. Making any changes to the setup requires admin login.

The initial idea is that the software must be able to:

1. Draw various types of graphs by loading a CSV file from the filesystem.

2. Automatically detect changes to the CSV files in the filesystem.

3. Display the contents of a webpage given a specific URI or contents of a PDF file

4. Display a table of data from an Microsoft Excel (.xlsx) file

5. Manage multiple screens

6. Manage both end-users and administrative users through login (if admin) and enable admins to do screen setup and configuration

8. Define each screen with both their resolution in pixels (e.g. 1920x1080 pixels) and in real size in centimeters (e.g. 40x25 cm) to make the gui properly display the data in correct size

7. Enable user defined setup of each screen. e.g. dividing the screen into 4 spaces, one for a graph(CSV), another for RDP and two web pages. This includes setting up the size of each element in cm. 
