## Docker Image

Generate the docker image run this command:

```bash
   docker build -t NAME_IMAGE_WITH_VERSION .
```

## Docker Container

Generate the docker container run this command:

```bash
   docker run -d -p 8080:8080 --name NAME_CONTAINER NAME_IMAGE_WITH_VERSION
```