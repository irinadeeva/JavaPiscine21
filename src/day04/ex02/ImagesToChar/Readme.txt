
mkdir lib
curl -s -o lib/jcommander-1.81.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.81/jcommander-1.81.jar
curl -s -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar

mkdir target
cp -R src/resources target
jar xf lib/jcommander-1.81.jar com/
jar xf lib/JCDP-4.0.2.jar com/
mv com target/

javac -cp target/ -d target/  src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/ArrayParse.java
jar cvfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN