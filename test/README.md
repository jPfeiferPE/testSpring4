# Application Test #

## Getting Started ##

You can create the war project by typing:

`mvn package` 

It's also possible deploy on tomcat if you configure your tomcat-users.xml and maven settings.xml.

`mvn tomcat:deploy`

The application uses Apache Derby Database.  To populate the Developer table, you can use curl:

`curl http://localhost:8080/test/rest/developer -d "{\"name\":\"John Smith\"}" -H "Content-Type: application/json"`

Also, `load_names.rb` file is provided, that will load the database with the contents of `names.txt`