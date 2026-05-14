#!/bin/sh
# Gradle wrapper stub - downloads gradle if needed
GRADLE_VERSION=8.11.1
GRADLE_DIR="$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin"
if [ ! -d "$GRADLE_DIR" ]; then
    echo "Downloading Gradle $GRADLE_VERSION..."
    mkdir -p "$GRADLE_DIR"
    curl -sL "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o /tmp/gradle.zip
    unzip -q /tmp/gradle.zip -d "$GRADLE_DIR"
    rm /tmp/gradle.zip
fi
GRADLE_BIN=$(find "$GRADLE_DIR" -name "gradle" -path "*/bin/gradle" | head -1)
exec "$GRADLE_BIN" "$@"
