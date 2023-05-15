# Exam System

## Introduction

The Examination System is a Java-based application that allows students to take exams, view question papers, and track their performance. In this, each student is rewarded with medals based on their test performance. It also provides an administrative interface to manage question papers and view the leaderboard. The application consists of several Java files that work together to implement the functionality. 

- [Admin.java](#adminjava)
- [Authentication.java](#authenticationjava)
- [Datasource.java](#datasourcejava)
- [Leaderboard.java](#leaderboardjava)
- [Main.java](#mainjava)
- [QuestionPaper.java](#questionpaperjava)
- [Security.java](#securityjava)
- [Student.java](#studentjava)

## Usage

- Download the repository:

```bash
    git clone https://github.com/adivishnu-a/ExamSystem
```

- Navigate to output folder:

```bash
    cd ExamSystem\out\production\ExamSystem
```

- Run the Project:

```bash
   java Main
```

- (Optional) If you want to Build from source, after cloning the repository, Compile the Java files using a Java compiler. For that, Make sure you have JDK (Java Development Kit) installed on your system and navigate to the [src](https://github.com/adivishnu-a/ExamSystem/tree/main/src) directory and run the following command. Then you can navigate to the [out](https://github.com/adivishnu-a/ExamSystem/tree/main/out/production/ExamSystem) folder and run the project using ```Main.class``` file:

```bash
   javac Admin.java Authentication.java Datasource.java Leaderboard.java Main.java QuestionPaper.java Security.java Student.java
```

- (Alternative) Run this app directly without all these steps by downloading the pre-built and pre-compiled version [here](https://github.com/adivishnu-a/ExamSystem/releases/tag/0.1.0)

# Documentation

## Admin.java

This class represents the administrator of the exam system. It provides functionality to view, add, edit, and delete question papers. It also has an option to view the leaderboard.

### Methods

- `viewPapers()`: Displays a list of question papers.
- `addPaper()`: Allows the administrator to add a new question paper.
- `editPaper()`: Allows the administrator to edit an existing question paper.
- `deletePaper()`: Allows the administrator to delete a question paper.
- `adminMenu()`: Displays the admin dashboard and handles user input.

## Authentication.java

Contains methods for user authentication, including student login, student signup, and admin login.

### Methods

- `stuLogin()`: To log in as an existing student
- `stuSignup()`: To create a new student account
- `adminLogin()`: To login as the administrator

## Datasource.java

This class handles data storage and retrieval for the exam system. It manages the list of users (students) and question papers. It also provides methods to read and save data to files.

### Methods

- `readFile()`: Reads user data from the file.
- `saveFile()`: Saves user data to the file.
- `readPapers()`: Reads question papers from the file.
- `savePapers()`: Saves question papers to the file.

## Leaderboard.java

Displays the leaderboard, which shows the rankings of students based on their medals.

### Methods

- `static showBoard()`: Displays the student leaderboard in a sorted order based on their medals

## Main.java

The main entry point of the application. It presents a menu to select user types and handles user interactions.

### Methods

- `public static void main(String[] args)`: Starts the program and presents a menu to select user types and handles user interactions.

## QuestionPaper.java

This class represents a question paper. It contains a list of questions and provides methods to read and save question paper data from/to a file. It also allows setting, editing, and taking exams.

### Classes

- `Question`: Represents a single question with the question text, options, and the correct answer.
- `QuestionPaper`: Represents a full question paper.

### Methods

- `readPaper()`: Reads question paper data from the file.
- `savePaper()`: Saves question paper data to the file.
- `setPaper()`: Allows setting up a new question paper.
- `editPaper()`: Allows editing an existing question paper.
- `takeExam()`: Allows a student to take an exam based on the question paper.

## Student.java

This class represents a student in the exam system. It provides functionality to view question papers, take exams, and view the leaderboard.

### Methods

- `viewPapers()`: Displays a list of question papers.
- `startExam()`: Allows the student to start an exam.
- `stuMenu()`: Displays the student dashboard and handles user input.

## Security.java

This class provides encryption and decryption functions for string and integer values. It uses Base64 encoding for encryption and decryption.

### Methods

- `encStr(String str)`: Encrypts a string using Base64 encoding.
- `decStr(String str)`: Decrypts an encoded string using Base64 decoding.
- `encInt(int i)`: Encrypts an integer value using Base64 encoding.
- `decInt(String str)`: Decrypts an encoded integer value using Base64 decoding.

## Contributing

Contributions to the Examination System are welcome. If you want to contribute, please follow these steps:

- Fork the repository.
- Create a new branch.
- Make your changes.
- Commit your changes.
- Push the branch to your forked repository.
- Submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
