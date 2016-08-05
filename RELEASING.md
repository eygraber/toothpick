# Snapshot
`./gradlew smoothie:clean smoothie:build smoothie:artifactoryPublish smoothie-utils:clean smoothie-utils:build smoothie-utils:artifactoryPublish -PBINTRAY_USERNAME=eygraber -PBINTRAY_KEY=`


# Release
`./gradlew smoothie:clean smoothie:build smoothie:bintrayUpload smoothie-utils:clean smoothie-utils:build smoothie-utils:bintrayUpload -PBINTRAY_USERNAME=eygraber -PBINTRAY_KEY=`
