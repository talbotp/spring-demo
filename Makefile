JAVA=java
LOG_DIR=./logs

ifeq (${shell uname}, Linux)
  MAVEN=./mvnw
else
  MAVEN=./mvnw.cmd
endif


clean:
	@rm -rf ${LOG_DIR}
	@${MAVEN} clean

build: clean
	@${MAVEN} install

run:
	${JAVA} -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=local

run2:
	${JAVA} -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=local2
