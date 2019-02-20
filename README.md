## Data Migration Across Heterogenous Clouds

This project **simulates** the data migration of data (pdf, text files) across different clouds (ex: Google Drive to AWS Cloud). The users could create an account on the web platform and their registered email id was verified using OTP sent to their email . 
There were existing solutions for this but they were downloading the files to their server and uploading onto the destination cloud. But our project transferred files across through network.
This project provided various features like Content Based Deduplication feature to avoid duplication and waste of storage. AES Encryption/Decryption feature to protect files during transmission. Compression/Decompression feature to help large files transmit successfully across the cloud without loss.

![Work Flow](https://github.com/Bharathgc/Data_Migration_Across_Heterogenous_Clouds/blob/master/Migration/Capture1.PNG)
### Getting Started

Download the project using `git clone` to the local machine

### Pre-Requisites

- Install [jdk 1.7](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- Install [MySQL 5.0](https://www.mysql.com/downloads/)
- Install [Eclipse(Indigo)](http://www.eclipse.org/downloads/packages/release/indigo/sr2)
- Install [Apache Tomcat 7.0](https://tomcat.apache.org/download-70.cgi)

### Installing and Deployment

- Open eclipse and create or choose the workspace and create new J2EE project named "Migration".
- Copy the source code and paste into workspace where you have created the project.
- Refresh eclipse and you can see the project files in the project explorer tab.
- Set server path to Apache tomcat folder.
- Open MySQL and create a new connection with host address as "localhost" and username as "root" and  password as "root".
- Test the connection and connect to it.
- Now right click on workspace in MySQL and choose "import from SQL statements". Now chose the file "db.sql" which is present
in "Migration" folder.
- Now the project is set. Start tomcat and run the project.  

