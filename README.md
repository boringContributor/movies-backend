# CIC Coding Assigment

## Backend task

The REST api is implemented with Java and Spring Boot
It is deployed on [https://cic-movie-backend.herokuapp.com/](https://cic-movie-backend.herokuapp.com/)

#### Swagger

- Swagger documentation enabled on {host}/swagger-ui/

#### Thoughts

- There are multiple locations and titles, if I want to query a title/location I can either remove the duplicates or return them as they are to show that multiple results exist for a given title/location

- There are possible null values within locations/titles. This can by either filtering these null values or providing a default value like "unknown"

- The filtering gets its params through path params. In this case it would be useful to encode these params as there could be special cases within locations (not every browser is chrome)
- Pagination also needs to be done, but for that task it's not necessary as everything is handled in-memory
-

#### Deployment

- There are a lot of ways to deploy such a spring boot application (GCP, AWS ..). I decided to go with heroku as it is easy to setup and free.
- Heroku allows the integration with GitHub. Every merge request to the main/master branch automatically deploys a new version. In that case it would be important to run tests and let the CI first successfully pass the pipeline
- The application can also be executed and deployed with docker.

```bash
## Build and run image/container
docker-compose up -d --build app
```

```bash
## Only run container if already built
docker-compose up -d app
```

#### Idea

- Endpoint to get geopoint lookup from given location to place them on a

#### Idea

I could not disable the cors policy with heroku that is why I could not deploy and show case my frontend
It still is hosted on [vercel](https://cic-frontend.vercel.app/)
