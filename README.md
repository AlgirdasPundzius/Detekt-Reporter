# Detekt gitlab quality reporter

## Installation
Base [Detekt](https://github.com/arturbosch/detekt) is required.

Add `detektPlugins 'pm.algirdas.detekt:codeanalysis:0.2.0''` in your build.gradle

Project is available in jCenter

## Usage
Use custom reporter for detekt 
```
custom {
    reportId = "DetektQualityOutputReport"
    destination = file("build/reports/detekt.json")
}
```
Have a job in your gitlab .yml for reports similar to this
```
detekt analysis:
  stage: analyze
  tags:
    - android
  script:
    - ./gradlew detekt
  artifacts:
    reports:
        codequality: app/build/reports/detekt.json
```

After that just enjoy your nice reports in future merge requests.