## STEP BY STEP TO RUN THE REPLICATION KIT

**Requirements**

- Docker version 23.0.6, build ef23cbc
- Docker Compose version 1.29.2, build 5becea4c  
  (_Higher versions may break the execution_)

### Steps

- Remove the `phpinfo()` line from `index.php` to clean up the GUI.
- Add the line `$lang = 'it';` after `$default_lang = 'en';` in `translations.inc.php` to set the language to Italian and allow the tests to run correctly.
- Modify the Dockerfile to fix the errors

_Obs:_ The current commit has modifications made

- Follow the steps on the [oficial documentation](https://zenodo.org/records/10800568):

> AddressBook execution, in order to run the desired application version, the following information must be changed in the following files:
> in dockerfile you only need to change the following line "COPY addressbookv8.1.0 /var/www/html" with the desired version (addressbookv8.10, addressbookv8.16 or addressbookv8.1.7).
> Now you need to create the docker image with the following command: ` docker build -t addressbookv8.1.0 .` (if you chose the 8.1.0 version)
> Finally, you need to change the following lines in the dockercompose file in a manner consistent with the chosen version, "image: addressbookv8.1.0:latest" and "- ./mysql-dump-8.1.0:/docker-entrypoint-initdb.d".
> Run the application with the command: `docker-compose up`.

- Execute the database configuration scripts manually:

An error may occur at runtime if the tables do not exist. To manually execute the table creation scripts:

1. Open a new terminal.
2. Navigate to the `/src/addressbook/mysql-dump-xxx` directory.
3. Run the following command to execute the table creation script:
   ```bash
   docker exec -i addressbook_db_1 mysql -uroot -proot addressbook < addressbook.sql
   ```
4. Check if the tables were created successfully:
   ```bash
   docker exec -it addressbook_db_1 mysql -uroot -proot -e "USE addressbook; SHOW TABLES;"
   ```

#### Now your application is running and ready to run tests.
