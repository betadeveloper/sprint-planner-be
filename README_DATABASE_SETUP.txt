1. Download and install a PostgreSQL server.

To do this, go to https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
Pick the operating system you use and download the latest version of PostgreSQL. (15.2)
Install the package. During installation you will be prompted to create a password for the database superuser postgres.
Make the password "12345678"
The port number the server should listen to is 5432.
Selected locale English, United States.
After installation, you will be asked whether to open stack builder right after, but you will not need it.

Also, if you havent yet installed H2 and flyway, you need to download and install them as well.
Flyway: https://flywaydb.org/download/community  (Version 9.16.0)
H2: http://www.h2database.com/html/download.html (Version 2.1.214)

2.Viewing the database

Now that you have downloaded and installed PostgreSQL you should have access to SQL shell(psql) and PgAdmin 4.
To open and view database, first, open PgAdmin 4. It will request a password, write the password you created during installation.
Then on the left side of the screen, press Servers, then PostgreSQL 15.
You will see the icon for Databases. Right click on it and create a database, name it "wdatabase".
Open the project, specifically the sprint folder, because that is where build.gradle file is
Open the terminal and use the command "gradle flywayMigrate"
You have now imported the database. To view the tables, press on your created database name, then Schemas, then Tables.
To see the information in a specific table, right click on it, hover over View/Edit Data and click on All Rows.

You can alter the database either in PgAdmin 4, or using a terminal(SQL Shell(psql)).
If you want to use the terminal, open SQL Shell(psql).
It will prompt you with inputs for Server, Database, Port, Username and password. You only need to write in the Database and password prompt. 
Write the name of your database when the prompt is "Database [postgres]:
Write the superuser password you created during the installation for the "Password for user postgres:" prompt
This will connect you to the database and you will be able to add new tables or attributes using SQL.
 
3.Exporting the database

After finishing your work on the database, you can create a file that others can import using flyway migrations.
To do this, click on a table you have changed in Pg Admin 4 and at the top of the screen press SQL.
Copy the SQL into a file, that you have to name, for example "V1__Create_sprint_table.sql".
The naming convention is Prefix(V), then the version number, in this case 1, then 2 underscores(__) and the name of the migration
(if it's more than 1 word it has to be separated with underscores)
Then put this .sql file in the \sprint\src\main\resources\db\migration" folder.

--- FOR ENVIRONMENT VARIABLES FOR WINDOWS---
To set the variable values, go to: "Edit the system environment variables" in your system.
Press "Environment Variables..."
Under System variables, press "New..."
In the space for Variable name, write the name of the variable. These are the same for everyone.
In the space for Variable value, write the value of the variable. These can be different for everyone.
You have to set three environment variables: DB_URL, DB_USER, DB_PASSWORD
EXAMPLE VALUES:
Variable name: DB_URL Variable value: jdbc:postgresql://localhost:5432/wdatabase
Variable name: DB_USER Variable value: postgres
Variable name: DB_PASSWORD Variable value: 12345678
After doing this, reload your development environment, so it recognizes the new environment variables.

--- FOR ENVIRONMENT VARIABLES FOR MAC--
Open the Terminal application on your MacOS.
Applications > Utilities > Terminal.
Once the Terminal window opens, type the following command:

nano ~/.bash_profile

This will open the .bash_profile file in the Nano text editor. If the file doesn't exist, it will create a new one.
In the Nano text editor, scroll to the bottom of the file and add the following lines:

export DB_URL=jdbc:postgresql://localhost:5432/wdatabase
export DB_USER=postgres
export DB_PASSWORD=12345678

This sets the values of the environment variables. Make sure to replace the values with your own values.
After adding the lines, press Control + X, then Y, and then Enter to save the changes and exit Nano.
To apply the changes, you need to either close the terminal and open it again or type the following command in the terminal:

source ~/.bash_profile
This will apply the changes to the current terminal session.
In terminal on IntelLiJ IDEA CE or VSC enter:sprint % gradle flywayMigrate -Pflyway.url=jdbc:postgresql://localhost:5432/wdatabase -Pflyway.user=postgres -Pflyway.password=12345678
 





