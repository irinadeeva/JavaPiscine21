find . -name "*.java" > sources.txt

mkdir target

javac -d target @sources.txt

java -cp target edu.school21.printer.app.Main
