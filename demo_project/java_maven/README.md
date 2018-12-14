# CI-test

used for CI

## how to use

### build

* build maven image (e.g. caicloud-maven-test:3.5.2-jdk-8-alpine)

`docker build -t caicloud-maven-test:3.5.2-jdk-8-alpine -f dockerfile_maven .`

* build java application

`docker run -it --rm --name my-maven-project -v "$HOME"/.m2:/root/.m2  -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven caicloud-maven-test:3.5.2-jdk-8-alpine mvn clean install`


* build app image

`docker build -t caicloud-spring-boot-test:1.0 .`

* run app 

`docker run -it -d -p 8080:8080 --name=caicloud-test caicloud-spring-boot-test:1.0`

* verification

`curl -i localhost:8080/caicloud/info`
