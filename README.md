# CRUD Template (backend)

## Installation

Clone repository:

```sh
git clone https://github.com/badmoodd/crud-template-backend.git
```

## Build the Project

Navigate to the project directory and build the project using Gradle:

```shell
cd crud-template-backend
gradle build
```

## Run the Database

Navigate to the project directory and start the database container using Docker Compose:

```shell
cd src/main/resources/static/music_industry_db/
docker-compose up -d
```

## Run the Application

Now you can run backend service:

```shell
cd crud-template-backend
gradle bootRun
```