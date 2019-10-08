FROM openjdk:8-jdk-slim
COPY /springboot-bookinfo-product-api/target/springboot-bookinfo-product-api-1.0.0-SNAPSHOT.jar springboot-bookinfo-product.jar
ENTRYPOINT ["java","-jar","/springboot-bookinfo-product.jar"]