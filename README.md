# Anagram Checker

This project provides a simple command-line application to check if two strings are anagrams of each other.

## Prerequisites

- Java 11 or higher
- Gradle

## Getting Started

1. Clone the repository:

```shell
git clone https://github.com/gdamoreira/anagram-checker.git
```

1. Build the project using Gradle:

```shell
cd anagram-checker
./gradlew clean build package
```

2. Run the application:

```shell
java -jar build/libs/beyonnex-anagram-checker.jar <string1> <string2>
```

Or through Gradle:

```shell
./gradlew run --args="<string1> <string2>"
```

Replace `<string1>` and `<string2>` with the two strings you want to check for anagrams.

## Example
To check if "listen" and "silent" are anagrams, run the following command:

```shell
java -jar build/libs/beyonnex-anagram-checker.jar "listen" "silent"
```
If the strings are anagrams, the application will display a message indicating that they are. Otherwise, it will indicate that they are not anagrams.

## License
This project is licensed under the MIT License.