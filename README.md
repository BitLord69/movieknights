# movieknights

Medlemmar:<br/>

<ul>
<li>Joacim Norbeck - nekcoj</li>
<li>Alexander Persson - miniharald</li>
<li>Jan-Erik "Janis" Karlsson - BitLord69</li>
<li>Carl-Johan "Calle" Hornestam - Carljohan-hornestam</li>

## Installation info

### Install Neo4J Community Edition

- https://neo4j.com/download-center/#community
- Connect to Neo4J using http://localhost:7474/browser/
  - Initial credentials are: neo4j/neo4j
  - After logging in it'll ask you to set a new password
- Make sure you have neo4j in your services.msc (systemctl) and have it autostart on boot
  - https://neo4j.com/docs/operations-manual/current/installation/windows/

### Install Neo4J plugin

- Download https://github.com/neo4j-contrib/neo4j-apoc-procedures/releases/download/4.2.0.0/apoc-4.2.0.0-all.jar
- Place it in your `Neo4Jinstallfolder/plugins` folder
- Add the following to your `Neo4Jinstallfolder/conf/neo4j.conf`
  ```
  dbms.directories.plugins=plugins
  # EDIT the import-directory to your relevant filepath
  dbms.directories.import=G:\\servicefy\\backend\\modules
  dbms.security.procedures.allowlist=apoc.export.*,apoc.uuid.*,apoc.periodic.iterate,apoc.cypher.runFile, apoc.create.uuid, apoc.path.subgraphAll
  apoc.import.file.enabled=true
  apoc.export.file.enabled=true
  apoc.uuid.enabled=true
  ```
- Make sure `dbms.directories.import` etc are not overriden by the defaults (duplicate entries)
- Changing your config-file requires you to restart the neo4j-service

- In the neo4j console, add these constraints (to see which constraints have been set, do a :schema in the Neo browser)
  ```
  CREATE CONSTRAINT ON (m:MKMovie)
  ASSERT m.uuid IS UNIQUE;
  CREATE CONSTRAINT ON (m:MKPerson)
  ASSERT m.uuid IS UNIQUE;
  CREATE CONSTRAINT ON (m:MKGenre)
  ASSERT league.uuid IS UNIQUE;
  ```
  
  - Create an index for the title
  ```
  CREATE INDEX index_title FOR (n:MKMovie)
  ON (n.title)
  ```
