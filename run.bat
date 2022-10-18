@echo off
if "%1" == "start" (
    echo Running program
    start "Running application" gradlew run --warning-mode all
    exit
)
if "%1" == "dep" (
    echo Running buildDependents task
    start "Building Dependents" gradlew buildDependents
    exit
)