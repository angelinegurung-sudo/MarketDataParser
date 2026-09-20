# MarketDataParser

A Java program that parses CSV market tick data and inserts it into a PostgreSQL database

## What does it do

- Reads a CSV file of market tick data line by line (symbol, price, quantity, side)
- Parses each row into a MarketTick object
- Inserts each parsed tick into a PostgreSQL market_ticks table using PreparedStatement with parameterised queries, to safely handle input values and prevent any malicious activities like sql injection

## Classes

- **`MarketTick.java`** — represents a single market tick (symbol, price, quantity, side)
- **`Parser.java`** — reads the CSV file and inserts each row into the database
- **`DatabaseConnector.java`** — handles the database connection setup

## Tech

- Java
- JDBC (`java.sql`)
- PostgreSQL
- Maven
