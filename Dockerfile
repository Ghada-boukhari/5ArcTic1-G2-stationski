# Utiliser une image de base Java
FROM openjdk:11-jdk

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR construit dans l'image
COPY target/gestion-station-ski-1.0.jar app.jar

# Commande à exécuter au démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]

