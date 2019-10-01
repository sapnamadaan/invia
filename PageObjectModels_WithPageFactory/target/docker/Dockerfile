FROM dockerfile/java:oracle-java8

VOLUME /tmp
ADD PageObjectModels_WithPageFactory.jar /opt/PageObjectModels_WithPageFactory/
EXPOSE 8080
WORKDIR /opt/PageObjectModels_WithPageFactory/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "PageObjectModels_WithPageFactory.jar"]
