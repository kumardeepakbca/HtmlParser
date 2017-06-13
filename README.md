Requirement:
java version "1.8.0_77"
Maven:apache-maven-3.3.9
IDE:Eclipse

How to import in eclipse?
1.	Import maven project in Eclipse
2.	Right click on pom.xml ->Run as-> Maven install
3.	Jar file generated in target folder.

Command prompt:

Run command inside folder at pom.xml: mvn clean install
Jar file will create in target folder.

Add following details in Config.properties file:
	1. html.file.watcher.path=
	2. html.file.archive.path=
	3. output.path=
	4. html.archived.file.deleted.days=

How to run jar file?
	java -jar <Jar file> <config.properties path>
	Ex: java -jar htmlParser.jar C:\html-parser\config.properties





