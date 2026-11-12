Atlas Ledger - Financial Transaction Management System

A Java-based financial transaction management application that allows users to track deposits and payments through a command-line interface (CLI). Transaction data is stored locally in a CSV file (transactions.csv), allowing financial records to persist between program executions.

Project Description

Atlas Ledger CLI provides a simple way to manage financial transactions, maintain a transaction history, and generate financial reports.

Users can:

Add deposits (positive transactions)

Record payments (negative transactions)

View all ledger entries

Filter transactions by deposits or payments

Generate financial reports:

Month-to-Date

Previous Month

Year-to-Date

Previous Year

Search by Vendor

Perform custom transaction searches using:

Start Date

End Date

Description

Vendor

Amount

The application automatically records the date and time of each transaction. Ledger entries are displayed in reverse chronological order, with the newest transactions appearing first.

Technologies Used

Java – Core application development

ArrayList – Transaction collection management

File I/O – CSV data persistence

BufferedReader

BufferedWriter

FileReader

FileWriter

Java Date/Time API

LocalDate

LocalTime

Object-Oriented Programming (OOP) – Application structure and organization

How to Run the Project

Prerequisites

Java JDK 17 or later

IntelliJ IDEA or another Java IDE

Installation & Setup

Clone or download the project repository.

Open the project in IntelliJ IDEA.

Ensure transactions.csv is located in the project root directory.

Build the project.

Run the Main class.

The Atlas Ledger CLI home screen will appear.

Application Menu

+--------------------------------------+
|           ATLAS LEDGER CLI           |
|   Financial Transaction Management   |
+--------------------------------------+

D) Add Deposit

P) Make Payment

L) Ledger

X) Exit

Follow the on-screen prompts to manage transactions, view ledger entries, and generate financial reports.

Project Structure

AtlasLedgerCLI/
│
├── .idea/
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── LedgerCLI/
│   │   │       ├── Ledger.java
│   │   │       ├── Main.java
│   │   │       ├── Menu.java
│   │   │       ├── Search.java
│   │   │       └── Transaction.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── target/
├── .gitignore
├── pom.xml
├── README.md
└── transactions.csv

Transaction File Format

All transactions are stored in transactions.csv using a pipe-delimited format:

date|time|description|vendor|amount

Example Transactions

2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50
2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00

Transaction conventions:

Positive amounts represent deposits.

Negative amounts represent payments.

Each transaction includes an automatically generated date and time.

Features Completed

CSV file persistence

Add Deposit

Make Payment

Ledger View

Deposit Filtering

Payment Filtering

Month-to-Date Report

Previous Month Report

Year-to-Date Report

Previous Year Report

Search by Vendor

Custom Search (Bonus Feature)

Custom CLI Branding (Bonus Feature)

Project Goals & Learning Outcomes

This project demonstrates practical Java programming concepts, including:

Object-oriented programming and class organization

Reading and writing files using Java File I/O

Managing collections with ArrayList

Working with Java's Date and Time API

Handling user input through a command-line interface

Implementing transaction filtering and search functionality

Developing custom financial reporting features

Atlas Ledger CLI brings these concepts together in a functional application designed to demonstrate foundational Java development and problem-solving skills.
