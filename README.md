# regex-sql
rest service which takes regex in [query string](https://en.wikipedia.org/wiki/Query_string) and return `List<T>` not matches with the regex.

**software stack:**
* java 8
* spring boot
* junit
* postgresql
* h2base

**how to run:**
* database dump and schema location: `src/main/resources/sql/`
* configure database in file `src/main/resources/application.properties`
* create jar with `mvn clean package`
