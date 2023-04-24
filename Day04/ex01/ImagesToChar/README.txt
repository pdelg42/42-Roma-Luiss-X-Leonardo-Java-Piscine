javac -d ./target -sourcepath ./src/java ./src/java/edu/school42/printer/app/Program.java ./src/java/edu/school42/printer/logic/Printer.java
jar cvfm ./target/images-to-chars-printer.jar src/manifest.txt -C target edu/ -C src/ resources
java -jar target/images-to-chars-printer.jar . o
