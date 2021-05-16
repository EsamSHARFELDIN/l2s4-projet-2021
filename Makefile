SOURCEFILES = $(shell find ./src -name '*.java')

.PHONY = all doc cls clean

all: agricol.jar

doc:
	javadoc game -sourcepath ./src -subpackages game -d ./doc

agricol.jar: classes/MainAgricolGame.class
	jar cvfe ./jar/agricole.jar game.MainAgricolGame -C ./classes .

classes/MainAgricolGame.class:
	javac -sourcepath ./src -d ./classes src/game/MainAgricolGame.java

cls:
	javac $(SOURCEFILES) -d ./classes

clean:
	rm -f ./jar/*.jar
	rm -rf ./doc
	rm -rf ./classes/*
