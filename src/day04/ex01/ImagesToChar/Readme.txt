find . -name "*.java" > sources.txt

mkdir target

javac -d target @sources.txt

java -cp target edu.school21.printer.app.Main

cp -R src/resources target/

jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

java -jar target/images-to-chars-printer.jar