POM_FILE:='.\java project\language\pom.xml'
JAVA_DIR:=.\java project\language\src\main\java\com\cmash

all: mvn-compile llvm

grammar:
	antlr Cmash.g4 -o '.\.antlr'
	javac '.\.antlr\*.java' 
	(cd '.\.antlr' && grun Cmash program -gui)

llvm: java-build
	llvm-as '$(JAVA_DIR)\test.ll' 
	lli '$(JAVA_DIR)\test.bc'

java-build:
	java '$(JAVA_DIR)\Main.java' '$(JAVA_DIR)\test.cmash' > '$(JAVA_DIR)\test.ll'
	cat '$(JAVA_DIR)\test.ll'

mvn-compile: 
	mvn -f $(POM_FILE) clean
	mvn -f $(POM_FILE) compile