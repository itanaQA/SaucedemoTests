# Selenium Practice - Saucedemo website

This repository contains a collection of automated tests for the [SauceDemo](https://www.saucedemo.com/) website, created as a practice exercise for Selenium-based automation using the Page Object Model (POM) design pattern.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  
## Project Overview
This project implements a comprehensive suite of Selenium WebDriver tests for the SauceDemo e-commerce platform. The tests cover various functionalities, such as user authentication, product browsing, cart management, and checkout processes.

## Features
- Page Object Model (POM) design for maintainable and scalable test automation.
- Data-driven testing using an external Excel file (`UserData.xlsx`).
- Comprehensive test cases for key workflows, including:
  - User login and logout.
  - Product sorting and validation.
  - Cart and checkout processes.

## Technologies Used
- **Java**: Programming language for test implementation.
- **Selenium WebDriver**: Browser automation tool.
- **TestNG**: Test framework for organizing and running test cases.
- **Maven**: Dependency management and build tool.
- **Apache POI**: Library for reading and writing Excel files.

## Project Structure
```
SaucedemoTests-master
├── pom.xml                  # Maven configuration file
├── UserData.xlsx            # Test data file
├── src
│   ├── main
│   │   └── java
│   │       └── org.example
│   │           └── Main.java
│   └── test
│       ├── java
│       │   ├── Base          # Base classes for tests
│       │   ├── Pages         # Page classes for POM
│       │   └── Tests         # Test classes for various scenarios
└── .gitignore
```

### Key Directories
- `Base`: Contains base test setup and utility classes.
- `Pages`: Implements Page Object Model classes for different web pages.
- `Tests`: Holds test classes for various test scenarios.

## Getting Started
### Prerequisites
Ensure you have the following installed:
- [Java 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [ChromeDriver](https://sites.google.com/chromium.org/driver/) (ensure it matches your Chrome browser version)

### Installation

1. Open terminal
On Windows, open Command Prompt or Git Bash.
On Mac/Linux, open the Terminal.

3. Clone this repository:
   ```bash
   git clone <https://github.com/itanaQA/SaucedemoTests>
   cd SaucedemoTests-master
   ```
4. Install dependencies:
   ```bash
   mvn clean install
   ```

