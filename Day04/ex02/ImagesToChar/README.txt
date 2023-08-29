#COMPILE
javac -cp ./lib/JColor-5.0.0.jar:./lib/jcommander-1.82.jar -d ./target -sourcepath ./src/java ./src/java/edu/school42/printer/app/Program.java ./src/java/edu/school42/printer/logic/Printer.java ./src/java/edu/school42/printer/app/Colors.java
jar cvfm ./target/images-to-chars-printer.jar src/manifest.txt -C target edu/ -C src/ resources
#RUN
java -cp target:./lib/jcommander-1.82.jar1:./lib/JColor-5.0.0.jar2 -jar ./target/images-to-chars-printer.jar --white=RED --black=GREEN

#DEFINED

BLACK	0x00000000
WHITE	0x00FFFFFF
RED		0x00FF0000
GREEN	0x0000FF00
BLUE	0x000000FF
CYAN	0x0000FFFF
YELLOW	0x00FFFF00
PURPLE	0x00FF00FF