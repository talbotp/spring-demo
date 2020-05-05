JAVA=java
LOG_DIR=./logs

ifeq (${shell uname}, Linux)
  MAVEN=./mvnw
else
  MAVEN=./mvnw.cmd
endif

quick:
	${MAVEN} spring-boot:run

clean:
	@rm -rf ${LOG_DIR}
	@${MAVEN} clean

build: clean
	@${MAVEN} install

run:
	${JAVA} -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

