# Terminal Commands:
docker
### To build 
`docker build .`

### To run
`docker run image_id`

### To see running processes
`docker ps`

### Stop container
`docker stop image_name`

### Run with Open port
`docker run -p localport:internal_dockercontainer_exposedPort image_id`

### Start container
`docker start image_name`

### Container in attach mode (default)
`docker run container_name`
`docker start -a container_name`

### Container in detach mode
`docker run -d image_id`

### Container terminal view
`docker attach container_name`

### Looking for logs
`docker logs container_name`
`docker logs -f container_name`