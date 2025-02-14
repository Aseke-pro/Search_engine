# Search_engine


 
The program searches by words on websites.
The site is indexed and all pages of the site are saved to the database.
Search management is carried out through the browser.

![1-1](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/1%2B1.png)


The stack of technologies used: Java 17, MySQL, Spring, Maven.

Instructions for the local launch of the project — a sequence of commands and actions
1. Install MySQL and IDEA on your PC.
2. Add the project to IDEA (instructions for adding it can be found on the Internet)
3. Attention is important to work correctly in MySQL, use Create BD.sql script will create correct tables in a clean database.
4. In the application.yaml in the username and password fields, specify your username and password from your database.(MySQL port 3306 should be free or change the urk field to your port)
5. In the application.yaml specify the names of the sites and their address(URL)

![1-2](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/1%2B2.png)


6. Update the dependencies in Maven
7. Launch the application and open your browser in the view (insert) line (http://localhost:8080 /) without brackets.
   You should see the Search Engine.

![1-3](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/1%2B3.png)

The status Failed means that there is no data on this site in the database.

In the Management tab, indexing of sites or pages belonging to the site is started.

![1-4](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/1%2B4.png)



Indicates an indexing error or the database is empty.

![2-1](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/2-1.png)



Indicates that indexing is in progress, site crawling and saving is being performed.

![2-2](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/2-2.png)


Indicates that indexing is complete.

![2-3](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/2-3.png)



Use Russian in the search.

![1-5](https://github.com/Aseke-pro/Search_engine/blob/main/src/main/resources/img/1%2B5.png)


The program works in multithreaded mode and uses all processor cores to quickly crawl the site through pages. A Russian-language lemotizer is used. To drop data from the database, use the SQL script. The scripts are located in the resource folder.

The final project in the course is a Java programmer from Skill Box.
The project was completed by Askar Kutlimuratov.
Contacts: tire.teri@gmail.com
