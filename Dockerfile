# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# Copy war file
COPY target/demo2-0.0.1-SNAPSHOT.jar /java.jar
# run the app
CMD ["/usr/bin/java", "-jar", "/java.jar", "-XX:MaxRam=2000m -Xms1700m -Xmx1700m  -XX:MinHeapFreeRatio=30 -XX:MaxHeapFreeRatio=50 -XX:GCTimeRatio=19 -XX:+UseSerialGC"]

#-XX:+UseParallelGC 
