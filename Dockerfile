FROM openjdk:11
VOLUME /tmp
EXPOSE 8000
ADD ./target/Product-0.0.1-SNAPSHOT.jar Product.jar
ENTRYPOINT ["java","-jar","/Product.jar"]