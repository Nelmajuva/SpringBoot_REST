FROM ubuntu:latest
LABEL authors="juan.lopez"

# Etapa 1: build con Gradle + JDK completo
FROM amazoncorretto:21 AS builder

# Crea el directorio de trabajo
WORKDIR /app

# Copia los archivos necesarios
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./
COPY src ./src

# Da permisos de ejecución al wrapper
RUN chmod +x ./gradlew

# Construye la aplicación (con shadowJar o bootJar)
RUN ./gradlew clean bootJar --no-daemon

# Etapa 2: imagen liviana solo con JRE
FROM amazoncorretto:21-alpine-jdk

# Crea usuario no root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Directorio de la app
WORKDIR /app

# Copia el JAR desde la etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Expone el puerto de la app
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]