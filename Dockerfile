FROM eclipse-temurin

COPY arbitraryarithmetic/aarithmetic.jar app/my.jar

ENTRYPOINT ["java", "-jar", "app/my.jar"]
CMD ["int", "add", "1", "1"]

